package com.clarity.spring.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@Column @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pedido;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = false,length = 100)
	private String nombre;
	
	@Column(nullable = false)
	private Date fecha_pedido;
	
	@Column(nullable = false, length = 100)
	private String apellidos;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EstadoPedido estado;
	
	@Column (length=8, unique = true)
	private String dni;
	
	@Column(nullable = false)
	private Double precio;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario; 
	
	public Pedido () {}
	
	public Pedido(long id_pedido, String direccion, String nombre, Date fecha_pedido, String apellidos,
			EstadoPedido estado, String dni, Double precio, Usuario usuario) {
		this.id_pedido = id_pedido;
		this.direccion = direccion;
		this.nombre = nombre;
		this.fecha_pedido = fecha_pedido;
		this.apellidos = apellidos;
		this.estado = estado;
		this.dni = dni;
		this.precio = precio;
		this.usuario = usuario;
	}


	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public enum EstadoPedido{
		Entregado,
		Rechazado,
		Pendiente,
		Carrito,
		Enviado
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", direccion=" + direccion + ", nombre=" + nombre + ", fecha_pedido="
				+ fecha_pedido + ", apellidos=" + apellidos + ", estado=" + estado + ", dni=" + dni + ", precio="
				+ precio + ", usuario=" + usuario + "]";
	}
	
	
	
}

