package com.clarity.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Pedido.EstadoPedido;
import com.clarity.spring.model.Usuario;

@Repository
public interface OrderRepository extends JpaRepository<Pedido, Long > {
	
	Pedido  findByUsuarioAndEstado(Usuario usuario, EstadoPedido estadtopedido);
}
