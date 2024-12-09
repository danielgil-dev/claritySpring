package com.clarity.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Column @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pedido;
	
//	@ManyToOne
//	@JoinColumn(name="id_usuario")
	
	
	
	
	
	
	
}
