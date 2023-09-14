package com.spring.product.service.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.product.entity.Cart;
import com.spring.product.entity.SubProduct;
import com.spring.product.repositories.CartRepository;
import com.spring.product.service.CartService;
import com.spring.product.service.SubProductService;
import com.spring.product.service.UserService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repo;
	@Autowired
	SubProductService ss;
	@Autowired
	UserService us;
	
	@Override
	public void addItemToCart(int subProductId,String userName) {
		// TODO Auto-generated method 
		
		SubProduct sub=ss.getSubProduct(subProductId);
		Cart cart=new Cart();
		cart.setProductId(subProductId);
		cart.setAmount(sub.getPrice());
		cart.setDate(new Date(System.currentTimeMillis()));
		cart.setUserId(us.getUser(userName).get().getUserId());
		cart.setProductName(sub.getSubProductName());
		
		repo.save(cart);
	}

	@Override
	public List<Cart> getCartItems(String userName) {
		// TODO Auto-generated method stub
		//System.out.println(userName);
		return repo.getCartForUser(us.getUser(userName).get().getUserId());
		
	}

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		repo.deleteById(cartId);
	}



}
