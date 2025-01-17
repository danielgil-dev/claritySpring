package com.clarity.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Pedido.EstadoPedido;
import com.clarity.spring.model.Producto;
import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.OrderRepository;
import com.clarity.spring.repository.ProductRepository;

@Service
public class PedidoService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public Pedido agregarPedidoAlCarrito(Long usuarioId, long productoId, long cantidad) {

		Producto producto = productRepository.findById(productoId)
				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

		if (producto.getCantidad_stock() < cantidad) {
			throw new IllegalArgumentException("Stock insuficiente");
		}

		return new Pedido();

	}

	public Pedido listarPedidoUsuarioEstadoCarrito(Usuario usuario) {
		Pedido pedido = orderRepository.findByUsuarioAndEstado(usuario, EstadoPedido.Carrito);
		return pedido;
	}

	public void eliminarLineaPedido(Long pedidoId) {

		Pedido pedido = orderRepository.findBypedidoId(pedidoId);
		if (pedido != null) {
			pedido.eliminarLineaPedido(null);
		}
	}

	
}
