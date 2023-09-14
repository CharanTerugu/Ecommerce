package com.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.entity.Product;
import com.spring.product.entity.SubProduct;
import com.spring.product.service.SubProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class SubProductController {

	
	@Autowired
	SubProductService ps;
	
	@PostMapping("/admin/product/{productId}/subproduct/add")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void addStock(@PathVariable int productId , @RequestBody SubProduct subProduct)
	{
		ps.addStockItem(productId, subProduct);
	}

	@GetMapping("/customer/product/view")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<SubProduct> viewAll()
	{
		return ps.getAll();
	}
	
	@GetMapping("/products/subproducts/all/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	List<Product> getAllProductsByCatageoryId(@PathVariable int id){
		return ps.getAllByCatagoery(id);
	}
	
	@PutMapping("/admin/subproduct/update/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void updateSubProduct(@PathVariable int id , @RequestBody SubProduct subProduct)
	{
		ps.updateSubProduct(id, subProduct);
	}
	
	@GetMapping("/products/subproducts/view/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	SubProduct getSubProductById(@PathVariable int id){
		return ps.getSubProduct(id);
	}
	
	
	
}
