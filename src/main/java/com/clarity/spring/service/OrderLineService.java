package com.clarity.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clarity.spring.model.LineaPedido;
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
	
//	
//	public List<LineaPedido> listarLineasPedido() {
//		
//		
//		return orderLineRepository.findByCantidadAndPrecioTotal(productRepository.existsById(null));
//	}

}
