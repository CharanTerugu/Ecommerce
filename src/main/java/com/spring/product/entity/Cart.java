package com.spring.product.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	int cardId;
	int productId;
	Date date;
	int userId;
	double amount;
	String productName;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cardId, int productId, Date date, int userId, double amount, String productName) {
		super();
		this.cardId = cardId;
		this.productId = productId;
		this.date = date;
		this.userId = userId;
		this.amount = amount;
		this.productName = productName;
	}

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
