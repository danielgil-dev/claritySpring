package com.clarity.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_producto;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private Double precio;
	
	
	
}
