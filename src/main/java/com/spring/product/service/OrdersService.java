package com.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.product.entity.Cart;
import com.spring.product.entity.Orders;
import com.spring.product.exceptions.DaysExceeds;
import com.spring.product.exceptions.OutOfStock;

@Component
public interface OrdersService {

	
	void save(int productId,Orders order,String userName) throws OutOfStock;
	List<Orders> getOrdersForUser(String userName);
	void placeOrder(List<Cart> cart);
	void returnOrder(int orderId) throws DaysExceeds;
}
