package com.spring.product.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue
	int productId;
	
	String productName;
	@ManyToOne
	@JoinColumn(name="catageoryId",referencedColumnName = "catageoryId")
	@JsonIgnore
	Catgeory catgeory;
	@OneToMany(mappedBy = "product")
	List<SubProduct> subProduct;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, Catgeory catgeory, List<SubProduct> subProduct) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.catgeory = catgeory;
		this.subProduct = subProduct;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Catgeory getCatgeory() {
		return catgeory;
	}
	public void setCatgeory(Catgeory catgeory) {
		this.catgeory = catgeory;
	}
	public List<SubProduct> getSubProduct() {
		return subProduct;
	}
	public void setSubProduct(List<SubProduct> subProduct) {
		this.subProduct = subProduct;
	}
	
	
}
