package com.clarity.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.spring.model.LineaPedido;

public interface OrderLineRepository extends JpaRepository<LineaPedido, Long > {
	
	LineaPedido findByPedidoAndProducto(Long idPedido, Long idProducto);
}
