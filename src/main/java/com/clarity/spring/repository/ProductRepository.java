package com.clarity.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarity.spring.model.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto,Long> {
	
	
}
