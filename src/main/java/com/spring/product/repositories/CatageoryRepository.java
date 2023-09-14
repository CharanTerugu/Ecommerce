package com.spring.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.product.entity.Catgeory;

@Repository
public interface CatageoryRepository extends JpaRepository<Catgeory, Integer>{

}
