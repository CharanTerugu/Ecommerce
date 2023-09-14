package com.spring.product.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

   @Query("select u from user u where u.userName=?1")
	Optional<User> findByName(String userName);
}
