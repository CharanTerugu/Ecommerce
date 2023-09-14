package com.spring.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "subproduct")
public class SubProduct {

	
	@Id
	@GeneratedValue
	int subProductId;
	String subProductName;
	
	int quantity;
	double price;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonBackReference
//	@JsonIgnoreProperties
//	User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id",referencedColumnName = "productId")
	@JsonIgnore
	Product product;
	public SubProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SubProduct(int subProductId, String subProductName, int quantity, double price, Product product) {
		super();
		this.subProductId = subProductId;
		this.subProductName = subProductName;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}


	public int getSubProductId() {
		return subProductId;
	}
	public void setSubProductId(int subProductId) {
		this.subProductId = subProductId;
	}
	public String getSubProductName() {
		return subProductName;
	}
	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

	
}
