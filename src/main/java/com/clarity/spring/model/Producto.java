package com.clarity.spring.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
	
	
	@ManyToMany
	@JoinTable(
			name = "producto_categoria",
			joinColumns = @JoinColumn(name= "producto_id"),
			inverseJoinColumns = @JoinColumn(name = "categorias_id")
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Producto () {}
	
	public Producto(Long producto_id, Double precio, String imagen, String descripcion, String nombre,
			Long cantidad_stock) {
		this.producto_id = producto_id;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cantidad_stock = cantidad_stock;
	}

	

	public Producto(Long producto_id, Double precio, String imagen, String descripcion, String nombre,
			Long cantidad_stock, List<LineaPedido> lineaPedidos, List<Reseña> reseñas, List<Categoria> categorias) {
		this.producto_id = producto_id;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cantidad_stock = cantidad_stock;
		this.lineaPedidos = lineaPedidos;
		this.reseñas = reseñas;
		this.categorias = categorias;
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
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

	public List<LineaPedido> getLineaPedidos() {
		return lineaPedidos;
	}

	public void setLineaPedidos(List<LineaPedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

	public List<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(List<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	//Metodos helpers de mi tabla Producto
	////Con estos dos metodos de agregar y eliminar mantengo la coherencia en ambas partes de la relaciones
	
	public void addCategoria(Categoria categoria) {
		
		this.categorias.add(categoria);
		categoria.getProductos().add(this);
	}
	
	//Agregar varias categorias a la vez
	public void addCategorias(List<Categoria> categorias) {
		for(Categoria categoria : categorias) {
			
			this.addCategoria(categoria);
		}
	}
	
	public void removeCategoria(Categoria categoria) {
		
		this.categorias.remove(categoria);
		categoria.getProductos().remove(this);
	}
	
	//Eliminar varias categorias a la vez
	public void removeCategoria(List<Categoria> categorias) {
		for(Categoria categoria : categorias) {
			this.removeCategoria(categoria);
		}
	}
	
	@Override
	public String toString() {
		return "Producto [producto_id=" + producto_id + ", precio=" + precio + ", imagen=" + imagen + ", descripcion="
				+ descripcion + ", nombre=" + nombre + ", cantidad_stock=" + cantidad_stock + ", lineaPedidos="
				+ lineaPedidos + ", reseñas=" + reseñas + ", categorias=" + categorias + "]";
	}
	
	
	
	
	
	
}
