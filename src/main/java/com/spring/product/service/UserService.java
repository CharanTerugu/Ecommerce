package com.spring.product.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.spring.product.entity.User;
import com.spring.product.exceptions.UserAlreadyReported;

@Component
public interface UserService {

	void signup(User user) throws UserAlreadyReported;
	Optional<User> getUser(String name);
	
}
