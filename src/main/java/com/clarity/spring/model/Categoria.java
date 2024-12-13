package com.clarity.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoria_id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public Categoria() {
		
	}
	
	public Categoria(Long categoria_id, String nombre, String descripcion, Producto producto) {
		this.categoria_id = categoria_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.producto = producto;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Categoria [categoria_id=" + categoria_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", producto=" + producto + "]";
	}
	
	
	
	
	
}
