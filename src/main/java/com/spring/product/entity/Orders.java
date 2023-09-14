package com.spring.product.entity;

import java.time.LocalDate;
import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue
	int orderId;
	int userId;
	 int productId;
	LocalDate orderDate;
	double totalAmount;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Orders(int orderId, int userId, int productId, LocalDate orderDate, double totalAmount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
