package com.spring.product.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.product.entity.Catgeory;
import com.spring.product.repositories.CatageoryRepository;
import com.spring.product.service.CatageoryService;

@Service
public class CatageoryServiceImpl implements CatageoryService{

	@Autowired
	CatageoryRepository repo;
	
	@Override
	public void addCatageory(Catgeory catgeory) {
		// TODO Auto-generated method stub
		repo.save(catgeory);
	}

	@Override
	public Catgeory getById(int catgeoryId) {
		// TODO Auto-generated method stub
		return repo.getById(catgeoryId);
	}

	@Override
	public List<Catgeory> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateCatageory(int catageoryId,Catgeory catgeory) {
		// TODO Auto-generated method stub
		
		Catgeory c=repo.getById(catageoryId);
		c.setCatageoryName(catgeory.getCatageoryName());
		repo.save(c);
		
		
	}

}
