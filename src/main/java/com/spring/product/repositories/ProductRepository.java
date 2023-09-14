package com.spring.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select p from product p where p.catgeory.catageoryId=?1")
	List<Product> getProductsByCatageoryId(int catageoryId);
	
	@Query("select p from product p where p.catgeory.catageoryName=?1")
	List<Product> getProductsByCatageoryName(String catageoryName);
	@Query("select p from product p where p.productName=?1")
	List<Product> getProductsByProductName(String productName);
}
