package com.spring.product.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity(name = "catgeory")
public class Catgeory {

	@Id
	@GeneratedValue
	int catageoryId;
	String catageoryName;
	@OneToMany(mappedBy = "catgeory")
	List<Product> product;
	public Catgeory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catgeory(int catageoryId, String catageoryName, List<Product> product) {
		super();
		this.catageoryId = catageoryId;
		this.catageoryName = catageoryName;
		this.product = product;
	}
	public int getCatageoryId() {
		return catageoryId;
	}
	public void setCatageoryId(int catageoryId) {
		this.catageoryId = catageoryId;
	}
	public String getCatageoryName() {
		return catageoryName;
	}
	public void setCatageoryName(String catageoryName) {
		this.catageoryName = catageoryName;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
}
