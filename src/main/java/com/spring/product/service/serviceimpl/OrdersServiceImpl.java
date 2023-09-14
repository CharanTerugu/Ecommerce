package com.spring.product.service.serviceimpl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.ser.MonthDaySerializer;
import com.spring.product.entity.Cart;
import com.spring.product.entity.Orders;
import com.spring.product.entity.Product;
import com.spring.product.entity.SubProduct;
import com.spring.product.entity.User;
import com.spring.product.exceptions.DaysExceeds;
import com.spring.product.exceptions.OutOfStock;
import com.spring.product.repositories.OrdersRepository;
import com.spring.product.service.CartService;
import com.spring.product.service.OrdersService;
import com.spring.product.service.ProductService;
import com.spring.product.service.SubProductService;
import com.spring.product.service.UserService;
import java.time.temporal.ChronoUnit;
@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersRepository repo;
	@Autowired
	JwtService js;
  @Autowired
  UserService us;
  @Autowired 
  SubProductService ps;
  @Autowired 
  CartService cs;
  
	@Override
	public void save(int productId,Orders order,String userName) throws OutOfStock {
		// TODO Auto-generated method stub
		
		
		Optional<User> u=us.getUser(userName);
		if(u.get().getAge()>60)
		{
			order.setTotalAmount(order.getTotalAmount()-(order.getTotalAmount()*0.7));
		}
		SubProduct p=ps.getSubProduct(productId);
		if(p.getQuantity()<=0)
		{
			throw new OutOfStock("Stock Unavailable");
		}
		p.setQuantity(p.getQuantity()-1);
		ps.save(p);
		int userId=u.get().getUserId();
		order.setProductId(productId);
		order.setUserId(userId);
		
		order.setOrderDate(LocalDate.now());
		repo.save(order);
		
	}
	@Override
	public List<Orders> getOrdersForUser(String userName) {
		// TODO Auto-generated method stub
		Optional<User> u=us.getUser(userName);
		
		return repo.getOrdersByUserId(u.get().getUserId());
	}
	@Override
	public void placeOrder(List<Cart> cart) {
		// TODO Auto-generated method stub
		
		Orders order;
		for(int i=0;i<cart.size();i++)
		{
			order=new Orders();
			order.setProductId(cart.get(i).getProductId());
			order.setTotalAmount(cart.get(i).getAmount());
			order.setUserId(cart.get(i).getUserId());
			order.setOrderDate(LocalDate.now());
			repo.save(order);
			
            cs.deleteCart(cart.get(i).getCardId());
		}
				
		
		
	}
	@Override
	public void returnOrder(int orderId) throws DaysExceeds {
		// TODO Auto-generated method stub
		
		Orders order=repo.getById(orderId);
		SubProduct sub=ps.getSubProduct(order.getProductId());
		long days=ChronoUnit.DAYS.between(order.getOrderDate(),LocalDate.now());
		System.out.println(days+""+LocalDate.now()+""+order.getOrderDate());
		if(days>40)
		{
			throw new DaysExceeds("No return applicable 40 days exceeds");
		}
		else
		{
			sub.setQuantity(sub.getQuantity()+1);
			ps.save(sub);
			repo.deleteById(orderId);
			
			
		}
	}
	
}
