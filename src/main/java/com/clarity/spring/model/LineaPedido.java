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
	
	@Id @Column(name = "id_linea_pedido") @GeneratedValue(strategy = GenerationType.IDENTITY )
	private long lineaPedidoId;
	
	@Column(nullable = false)
	private Double precio_total;
	
	@Column(nullable = false)
	private Long cantidad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_producto")
	private Producto producto;

	
	public LineaPedido() {
		
	}
	public LineaPedido(long id_linea_pedido, Double precio_total, Long cantidad, Pedido pedido, Producto producto) {
		this.lineaPedidoId = id_linea_pedido;
		this.precio_total = precio_total;
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
	}

	public long getId_linea_pedido() {
		return lineaPedidoId;
	}

	public void setId_linea_pedido(long id_linea_pedido) {
		this.lineaPedidoId = id_linea_pedido;
	}

	public Double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
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
	
	public Double calcularTotalLinea(Producto producto, Long cantidad) {
		
		return producto.getPrecio() * cantidad;
	}
	
	@Override
	public String toString() {
		return "LineaPedido [id_linea_pedido=" + lineaPedidoId + ", precio_total=" + precio_total + ", cantidad="
				+ cantidad + ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
	
	
}
