package com.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.entity.Cart;
import com.spring.product.entity.Orders;
import com.spring.product.exceptions.OutOfStock;
import com.spring.product.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class CartController {

	@Autowired
	CartService cs;
	
	@PostMapping("/customer/cart/{productId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
     void saveCart(@PathVariable int productId,HttpServletRequest request)
	{
		//System.out.print(request.getUserPrincipal().getName());
	
		cs.addItemToCart(productId,request.getUserPrincipal().getName());
		
		
		
	}
	
	@GetMapping("/customer/cart")
	@PreAuthorize("hasAuthority('ROLE_USER')")
    List<Cart> getCart(HttpServletRequest request)
	{
	
	
		return cs.getCartItems(request.getUserPrincipal().getName());
		
		
		
	}
}
