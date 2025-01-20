package com.clarity.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.LineaPedido;
import com.clarity.spring.repository.OrderLineRepository;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepository orderLineRepository;

	

	public void eliminarLineaPedido(Long idLineaPedido) {
		
		if (orderLineRepository.existsById(idLineaPedido)) {
		
			orderLineRepository.deleteById(idLineaPedido);
		}
	}
	
	public LineaPedido buscarLineaPedidoById(Long lineaPedidoId) {
		
		
		LineaPedido lineaPedido = orderLineRepository.findById(lineaPedidoId).orElse(null);
		
		return lineaPedido;
	}
	
	public LineaPedido actualizarLineaPedido(Long lineaPedidoId, Long cantidad) {
		LineaPedido lineaPedido = orderLineRepository.findById(lineaPedidoId).orElse(null);
		lineaPedido.setCantidad(cantidad);
		orderLineRepository.save(lineaPedido);
		return lineaPedido;
	}
}
