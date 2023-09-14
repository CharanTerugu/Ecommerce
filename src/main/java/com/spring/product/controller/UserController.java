package com.spring.product.controller;

import org.springframework.security.core.Authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.dto.AuthenticationModel;
import com.spring.product.entity.User;
import com.spring.product.exceptions.UserAlreadyReported;
import com.spring.product.service.UserService;
import com.spring.product.service.serviceimpl.JwtService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	UserService us;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@PostMapping("/user/new")
	ResponseEntity<?> signup(@RequestBody User user){
		
		try {
			 us.signup(user);
			 return new ResponseEntity("Account created successfully", HttpStatus.CREATED);
			 
		}
		catch(UserAlreadyReported e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.ALREADY_REPORTED);
		}
		
		
		
		
	}
	
	
	@PostMapping("user/authenticate")
	  ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthenticationModel auth)  {
			
			Authentication authentication ;
			try
			{
	      authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));
	     String token= jwtService.generateToken(auth.getUserName(),authentication.getAuthorities());
	   
	     return new ResponseEntity(token,HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity("Invalid credentials ",HttpStatus.UNAUTHORIZED);
			}
	       
	  }
	
	@PostMapping("user/logout")
	void logout(HttpServletRequest request) throws ServletException
	{
		try {
			
			request.logout();
			
			
			
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
		}
		jwtService.generateToken(null, null);
	}

	@GetMapping("/customer/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	Optional<User> getUser(HttpServletRequest request){
		return us.getUser(request.getUserPrincipal().getName());
	}
}
