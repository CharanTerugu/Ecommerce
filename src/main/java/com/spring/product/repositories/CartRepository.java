package com.spring.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	
	@Query("select c from cart c where c.userId=?1")
	List<Cart> getCartForUser(int userId);

}
