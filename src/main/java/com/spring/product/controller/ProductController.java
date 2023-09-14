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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.entity.Product;
import com.spring.product.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

	
	@Autowired
	ProductService ps;
	
	@PostMapping("/admin/catageory/{catageoryId}/product/add")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> addProduct(@PathVariable int catageoryId,@RequestBody Product product){
		try {
			ps.addProduct(catageoryId, product);
			return new ResponseEntity("Product added successfully",HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/admin/catageory/products/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<Product> getAll(){
		return ps.getAll();
	}
	
	@GetMapping("/admin/catageory/products/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<Product> getAllByCatageory(@PathVariable int id){
		return ps.getProductsByCatageoryId(id);
	}
	
	@PutMapping("/admin/catageory/products/update/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void updatePrdouct(@PathVariable int id,@RequestBody Product product)
	{
		ps.updateProduct(id, product);
	}
	
	
	@GetMapping("/admin/catageory/product/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	Product getProduct(@PathVariable int id)
	{
		return ps.getProductById(id);
	}
	
	@GetMapping("/customer/catageory/Products/{catageoryName}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<Product> getAllByCatageoryName(@PathVariable String catageoryName)
	{
		return ps.getProductByCatageoryName(catageoryName);
	}
	
	@GetMapping("/customer/catageory/Products/SubProducts/{productName}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<Product> getAllByProductName(@PathVariable String productName)
	{
		return ps.getProductByProductName(productName);
	}
	
	
}
