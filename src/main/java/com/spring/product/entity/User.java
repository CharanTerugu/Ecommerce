package com.spring.product.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name ="user")
public class User {
	
	@Id 
	@GeneratedValue
    int userId;
	String userName;
	String email;
	int age;
	String roles;
	String password;
//	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
//	@JsonManagedReference
//	@JsonIgnoreProperties
//	
//	List<SubProduct> product;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String email, int age, String roles, String password
			) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.age = age;
		this.roles = roles;
		this.password = password;
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	
}
