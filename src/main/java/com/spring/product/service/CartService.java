package com.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.spring.product.entity.Cart;

@Component
public interface CartService {

	void addItemToCart(int subProductId,String userName);
	List<Cart> getCartItems(String userName);
void deleteCart(int cartId);
}
