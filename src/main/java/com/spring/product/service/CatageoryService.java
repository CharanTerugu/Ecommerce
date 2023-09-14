package com.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.product.entity.Catgeory;

@Component
public interface CatageoryService {

	
	void addCatageory(Catgeory catgeory);
	Catgeory getById(int catgeoryId);
	List<Catgeory> getAll();
	void updateCatageory(int catageoryId,Catgeory catgeory);
}
