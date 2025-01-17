package com.clarity.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.spring.model.LineaPedido;
import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Producto;

public interface OrderLineRepository extends JpaRepository<LineaPedido, Long > {
	
	LineaPedido findByPedidoAndProducto(Pedido pedido, Producto producto);
	LineaPedido findByProducto(Producto producto);
	LineaPedido findBylineaPedidoId(Long lineaPedidoId);
	
	
}
