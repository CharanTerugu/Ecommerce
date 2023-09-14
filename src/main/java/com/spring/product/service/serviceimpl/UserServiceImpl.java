package com.spring.product.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.product.entity.User;
import com.spring.product.exceptions.UserAlreadyReported;
import com.spring.product.repositories.UserRepository;
import com.spring.product.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void signup(User user) throws UserAlreadyReported {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(repo.findByName(user.getUserName()).isPresent()) {
			throw new UserAlreadyReported("The username already exsists ");
		}
		repo.save(user);
	}

	@Override
	public Optional<User> getUser(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	

}
