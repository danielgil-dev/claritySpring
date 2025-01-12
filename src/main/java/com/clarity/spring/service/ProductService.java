package com.clarity.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clarity.spring.model.Producto;
import com.clarity.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public List<Producto> listarProductos(){
		
		return this.productRepository.findAll();
	}
	
	
}