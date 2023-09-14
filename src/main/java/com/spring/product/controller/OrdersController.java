package com.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.entity.Cart;
import com.spring.product.entity.Orders;
import com.spring.product.exceptions.DaysExceeds;
import com.spring.product.exceptions.OutOfStock;
import com.spring.product.service.OrdersService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class OrdersController {

	@Autowired
	OrdersService os;
	
	@PostMapping("/customer/order/{productId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ResponseEntity<?> saveOrder(@PathVariable int productId,@RequestBody Orders order,HttpServletRequest request)
	{
	//	System.out.print(request.getUserPrincipal().getName());
		try {
		os.save(productId, order,request.getUserPrincipal().getName());
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (OutOfStock e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/customer/profile/{userName}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<Orders> getAllOrdersForUser(@PathVariable String userName){
		return os.getOrdersForUser(userName);
	}
	
	@PostMapping("/customer/cart/order")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	void placeOrderInCart(@RequestBody List<Cart> cart ){
		 os.placeOrder(cart);
	}
	
	@DeleteMapping("/customer/return/{orderId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ResponseEntity<?> returnOrder(@PathVariable int orderId){
		try {
			os.returnOrder(orderId);
			return new ResponseEntity<>("Return initiated ",HttpStatus.OK);
		}
		catch (DaysExceeds e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
