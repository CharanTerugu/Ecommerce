package com.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.product.entity.Product;

@Component
public interface ProductService {

	void addProduct(int catageoryId,Product product);
	Product getById(int productId);
	List<Product> getAll();
	List<Product> getProductsByCatageoryId(int catageoryId);
	void updateProduct(int productId,Product product);
	Product getProductById(int id);
	List<Product> getProductByCatageoryName(String catageoryName);
	List<Product> getProductByProductName(String productName);
}
