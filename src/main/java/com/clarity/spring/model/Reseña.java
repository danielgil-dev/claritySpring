package com.clarity.spring.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
public class Reseña {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_reseña", nullable = false)
	private LocalDate fecha;
	
	@Column(nullable = false)
	@Min(value = 0, message = "La calificación no puede ser menor a 0.")
	@Max(value = 5, message = "La calificación no puede ser mayor a 5.")
	private Integer calificacion; 
	
	
	@Column(nullable = false)
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private User usuario;
	
	

	public Reseña(Long id, LocalDate fecha,
			@Min(value = 0, message = "La calificación no puede ser menor a 0.") @Max(value = 5, message = "La calificación no puede ser mayor a 5.") Integer calificacion,
			String contenido, User usuario) {
		this.id = id;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.contenido = contenido;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Reseña [id=" + id + ", fecha=" + fecha + ", calificacion=" + calificacion + ", contenido=" + contenido
				+ ", usuario=" + usuario + "]";
	}
	
	
	
}
