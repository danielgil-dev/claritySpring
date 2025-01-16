package com.clarity.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarity.spring.model.LineaPedido;
import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Usuario;
import com.clarity.spring.service.CartService;
import com.clarity.spring.service.OrderLineService;
import com.clarity.spring.service.PedidoService;
import com.clarity.spring.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PedidoService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderLineService orderLineService;
	
	@GetMapping
	public String cartPage(@AuthenticationPrincipal UserDetails userDetails, Model model ) {
		
		if(userDetails== null) {
			return "redirect: auth/login";
		}
		Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
		Pedido pedidoUsuario = this.orderService.listarPedidoUsuario(usuario);
		List<LineaPedido> listaPedidos = pedidoUsuario != null ? pedidoUsuario.getLineasPedido() : null;

		model.addAttribute("listaPedidos", listaPedidos);
		model.addAttribute("carritoVacio", listaPedidos == null || listaPedidos.isEmpty());
		model.addAttribute("pedidoUsuario",pedidoUsuario);
		return "public/cart";
		
	}
	
	@PostMapping("/add")
	public String addToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long idProducto) {
		
		if(userDetails == null) {
			return "redirect: auth/login";
		}
		
		  if (idProducto == null) {
		        throw new IllegalArgumentException("ID del producto no proporcionado");
		    }
		cartService.agregarProdutoAcarrito(userDetails.getUsername(), idProducto);
		return "redirect:/cart";
	}
	
	@PostMapping("/delete")
	public String deleteOrderLine(@RequestParam Long pedidoId) {
		
		orderService.eliminarLineaPedido(pedidoId);
		return "redirect:/cart";
	}
}
