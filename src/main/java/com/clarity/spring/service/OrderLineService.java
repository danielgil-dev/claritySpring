package com.clarity.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.clarity.spring.model.LineaPedido;
import com.clarity.spring.model.Pedido;
import com.clarity.spring.repository.OrderLineRepository;
import com.clarity.spring.repository.OrderRepository;
import com.clarity.spring.repository.ProductRepository;

public class OrderLineService {
	
	@Autowired
	private OrderLineRepository orderLineRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	
//	public LineaPedido crearLineaPedido(Long idPedido, Long idProducto) {
//		
//		LineaPedido lineaPedido = orderLineRepository.findByPedidoAndProducto(idPedido, idProducto);
//		
//		if(lineaPedido == null) {
//			Pedido pedido =  new Pedido();
//		}
//		return lineaPedido;
//	}
	
}
