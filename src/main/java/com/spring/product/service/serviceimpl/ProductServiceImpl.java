package com.spring.product.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.product.entity.Catgeory;
import com.spring.product.entity.Product;
import com.spring.product.repositories.ProductRepository;
import com.spring.product.service.CatageoryService;
import com.spring.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	@Autowired
	CatageoryService cs;
	@Override
	public void addProduct(int catageoryId, Product product) {
		// TODO Auto-generated method stub
		
		Catgeory c=cs.getById(catageoryId);
		product.setCatgeory(c);
		repo.save(product);
	}
	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return repo.getById(productId);
	}
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public List<Product> getProductsByCatageoryId(int catageoryId) {
		// TODO Auto-generated method stub
		return repo.getProductsByCatageoryId(catageoryId);
	}
	@Override
	public void updateProduct(int productId,Product product) {
		// TODO Auto-generated method stub
		Product p=repo.getById(productId);
		p.setProductName(product.getProductName());
		repo.save(p);
		
	}
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
	
	@Override
	public List<Product> getProductByCatageoryName(String catageoryName) {
		// TODO Auto-generated method stub
		return repo.getProductsByCatageoryName(catageoryName);
	}
	@Override
	public List<Product> getProductByProductName(String productName) {
		// TODO Auto-generated method stub
		return repo.getProductsByProductName(productName);
	}

}
