package com.clarity.spring.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long producto_id;
	
	@Column(nullable = false)
	private Double precio;
	
	@Column(nullable = false)
	private  String imagen;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private  String nombre;
	
	@Column(nullable = false)
	private Long cantidad_stock;
	
	@OneToMany (mappedBy = "producto")
	private List<LineaPedido> lineaPedidos;
	
	@OneToMany
	private List<Reseña> reseñas;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(
			name = "producto_categoria",
			joinColumns = @JoinColumn(name= "producto_id"),
			inverseJoinColumns = @JoinColumn(name = "categorias_id")
			)
	private List<Categoria> categorias;
	
	public Producto () {}
	
	public Producto(Long id_producto, Double precio, String imagen, String descripcion, String nombre,
			Long cantidad_stock, Categoria categoria) {
		this.producto_id = id_producto;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cantidad_stock = cantidad_stock;
		this.categoria = categoria;
	}

	
	
	
}
