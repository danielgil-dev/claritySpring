package com.clarity.spring.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo obligatorio")
	@Column(nullable = false)
	private String telefono;
	
	@NotBlank(message = "Campo obligatorio")
	@Column(nullable = false)
	private String direccion;
	
	@NotBlank(message = "Campo obligatorio")
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@NotBlank(message = "Campo obligatorio")
	@Column(nullable = false)
	private String apellido;
	
	@Email(message = "Debe proporcionar un email válido")
	@NotBlank(message = "Campo obligatorio")
	@Column(name ="email",nullable = false, unique = true)
	private String email;
	
	@Column( nullable = false)
	private String role = "usuario";
	
	@Size(min= 9, message = "Debe proporcionar un dni valido ")
	@Column(nullable = false)
	private String dni;
	
	@Size(min=8, message = "La contraseña debe de tener minimo 8 caracteres")
	@NotBlank(message = "Campo obligatorio")
	@Column(name = "password",nullable = false)
	private String contrasenya;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Reseña> reseñas;
	
	public Usuario() {
		
	}
	


	public Usuario(Long id, @NotBlank(message = "Campo obligatorio") String telefono,
			@NotBlank(message = "Campo obligatorio") String direccion,
			@NotBlank(message = "Campo obligatorio") String nombre,
			@NotBlank(message = "Campo obligatorio") String apellido,
			@Email(message = "Debe proporcionar un email válido") @NotBlank(message = "Campo obligatorio") String email,
			String role, String dni,
			@Size(min = 8, message = "La contraseña debe de tener minimo 8 caracteres") @NotBlank(message = "Campo obligatorio") String contrasenya,
			List<Pedido> pedidos, List<Reseña> reseñas) {
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.role = role;
		this.dni = dni;
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

	public void deletePedido(Pedido p) {
		// Delete del arrayList igualando el id del pedido que me llega por parametro 
		p.setUsuario(null);
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
	
	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}


	



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", email=" + email + ", role=" + role + ", contrasenya=" + contrasenya
				+ ", pedidos=" + pedidos + ", reseñas=" + reseñas + "]";
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



	
	
}
