package com.clarity.spring.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(List<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	@Column(name ="email",nullable = false, unique = true)
	private String email;
	
	@Column
	private String role;
	
	@Column(name = "password",nullable = false)
	private String contrasenya;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Reseña> reseñas;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String telefono, String direccion, String nombre, String apellido, String email,
			String role, String contrasenya, List<Pedido> pedidos, List<Reseña> reseñas) {
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.role = role;
		this.contrasenya = contrasenya;
		this.pedidos = pedidos;
		this.reseñas = reseñas;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", email=" + email + ", contrasenya=" + contrasenya + "]";
	}




	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}



	
	
}
