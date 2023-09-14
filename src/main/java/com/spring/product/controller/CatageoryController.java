package com.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.entity.Catgeory;
import com.spring.product.service.CatageoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class CatageoryController {

	
	@Autowired
	CatageoryService cs;
	
	@PostMapping("/admin/catageory/add")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> addCatageory(@RequestBody Catgeory catgeory){
		try {
			cs.addCatageory(catgeory);
			return new ResponseEntity("Catageory added successfully",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@GetMapping("/products/catageory/all")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	List<Catgeory> getAll()
	{
		return cs.getAll();
	}
	
	@GetMapping("/admin/catageory/fetch/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	Catgeory getById(@PathVariable int id)
	{
		return cs.getById(id);
	}
	
	
	@PutMapping("/admin/catageory/update/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void update(@PathVariable int id,@RequestBody Catgeory catgeory)
	{
		cs.updateCatageory(id, catgeory);
	}
}
