package com.spring.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	
	@Query("select o from orders o where o.userId=?1")
	List<Orders> getOrdersByUserId(int userId);
}
