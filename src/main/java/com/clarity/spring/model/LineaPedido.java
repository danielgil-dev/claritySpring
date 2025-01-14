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
	
	@Column(nullable = false)
	private Double precio_total;
	
	@Column(nullable = false)
	private int cantidad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_producto")
	private Producto producto;

	
	public LineaPedido() {
		
	}
	public LineaPedido(long id_linea_pedido, Double precio_total, int cantidad, Pedido pedido, Producto producto) {
		this.id_linea_pedido = id_linea_pedido;
		this.precio_total = precio_total;
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
	}

	public long getId_linea_pedido() {
		return id_linea_pedido;
	}

	public void setId_linea_pedido(long id_linea_pedido) {
		this.id_linea_pedido = id_linea_pedido;
	}

	public Double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "LineaPedido [id_linea_pedido=" + id_linea_pedido + ", precio_total=" + precio_total + ", cantidad="
				+ cantidad + ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
	
	
}
