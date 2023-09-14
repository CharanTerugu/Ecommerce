package com.spring.product.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.product.dto.UserDetailsImpl;
import com.spring.product.entity.User;
import com.spring.product.repositories.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user=repo.findByName(userName);
		return user.map(UserDetailsImpl::new).orElseThrow(()->new UsernameNotFoundException("User not found "));
	
	}
}