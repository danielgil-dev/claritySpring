package com.clarity.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LineaPedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id_linea_pedido;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private Double precio_total;
	
	@Column(nullable = false)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
}
