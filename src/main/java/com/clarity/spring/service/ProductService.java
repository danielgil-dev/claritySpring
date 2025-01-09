package com.clarity.spring.service;

import org.springframework.stereotype.Service;

import com.clarity.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
}
