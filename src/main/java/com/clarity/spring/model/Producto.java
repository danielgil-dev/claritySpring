package com.clarity.spring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_producto;
	
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
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	public Producto () {}
	
	public Producto(Long id_producto, Double precio, String imagen, String descripcion, String nombre,
			Long cantidad_stock, Categoria categoria) {
		this.id_producto = id_producto;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cantidad_stock = cantidad_stock;
		this.categoria = categoria;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(Long cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
