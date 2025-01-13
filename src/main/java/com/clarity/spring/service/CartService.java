package com.clarity.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Pedido.EstadoPedido;
import com.clarity.spring.model.Producto;
import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.OrderRepository;
import com.clarity.spring.repository.ProductRepository;
import com.clarity.spring.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Pedido crearNuevoCarrito(Usuario usuario) {
		
		Pedido pedidoNuevo = new Pedido();
		pedidoNuevo.setUsuario(usuario);
		pedidoNuevo.setApellidos(usuario.getApellido());
		pedidoNuevo.setDireccion(usuario.getDireccion());
//		pedidoNuevo.setDni(usuario.get)
		pedidoNuevo.setEstado(EstadoPedido.Carrito);
		pedidoNuevo.setPrecio(0.0);
		
	
		
		return orderRepository.save(pedidoNuevo);
		
	}
	
	public void agregarProdutoAcarrito(String username, Long idProducto) {
		
		Usuario usuario = userRepository.findByEmail(username);
		 Pedido pedido = orderRepository.findByUsuarioAndEstado(usuario, EstadoPedido.Carrito);
				 if(pedido == null) {
					 crearNuevoCarrito(usuario);
				 }
	                
		 
		 Producto producto = productRepository.findById(idProducto)
				 .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado")); 
		 
		 orderRepository.save(pedido);
		 
	}
	
	
	
}
