package com.spring.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.SubProduct;

@Repository
public interface SubProductRepository extends JpaRepository<SubProduct, Integer> {

	@Query("select s from subproduct s where s.product.productId=?1")
	SubProduct getSubProductFromProductId(int prooductId);

}
