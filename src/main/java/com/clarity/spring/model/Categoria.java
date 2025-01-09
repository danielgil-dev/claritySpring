package com.clarity.spring.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoria_id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String descripcion;
	
	@ManyToMany(mappedBy = ("categorias"))
	private List<Producto> productos = new ArrayList<>();;
	
	
	public Categoria() {
		
	}


	public Categoria(Long categoria_id, String nombre, String descripcion) {
		this.categoria_id = categoria_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	@Override
	public String toString() {
		return "Categoria [categoria_id=" + categoria_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", productos=" + productos + "]";
	}
	
	
	
	
	
	
	
	
	
}
