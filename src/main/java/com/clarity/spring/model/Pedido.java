package com.clarity.spring.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

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
	private LocalDateTime fecha_pedido;
	
	@Column(nullable = false, length = 100)
	private String apellidos;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EstadoPedido estado;
	
	@Column (length=9)
	private String dni;
	
	@Column(nullable = false)
	private Double precio;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario; 
	
	//Esto me indica que un pedido puede tener muchas lineas de pedido asociadas al pedido
	//El mappedBy me indica que el campo pedido en la clase LineaPedido, hace que la lineaDePedido sea el propietario de la relacion 
	@OneToMany(mappedBy = "pedido" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineaPedido> lineasPedido = new ArrayList<>();
	
	public Pedido () {}
	


	

	public Pedido(long id_pedido, String direccion, String nombre, LocalDateTime fecha_pedido, String apellidos,
			EstadoPedido estado, String dni, Double precio, Usuario usuario, List<LineaPedido> lineasPedido) {
		this.id_pedido = id_pedido;
		this.direccion = direccion;
		this.nombre = nombre;
		this.fecha_pedido = fecha_pedido;
		this.apellidos = apellidos;
		this.estado = estado;
		this.dni = dni;
		this.precio = precio;
		this.usuario = usuario;
		this.lineasPedido = lineasPedido;
	}





	@PrePersist
	public void onCreateDate() {
		//Antes de que JPA cree mi entidad pedido si no hay una fecha le asigno la fecha actual
		if(fecha_pedido == null) {fecha_pedido = LocalDateTime.now();}
			
	}
	
	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	
	//Metodos helper para mantener la relacion entre mis entidades Pedido y LineaDePedidos
	//Establezco los 
	public void agregarLineaPedido(LineaPedido lineaPedido) {
		this.lineasPedido.add(lineaPedido);
		lineaPedido.setPedido(this);
	}
	
	public void eliminarLineaPedido(LineaPedido lineaPedido) {
		this.lineasPedido.remove(lineaPedido);
		lineaPedido.setPedido(null);
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

	

	public LocalDateTime getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(LocalDateTime fecha_pedido) {
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

