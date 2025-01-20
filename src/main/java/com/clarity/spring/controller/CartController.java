package com.clarity.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarity.spring.model.LineaPedido;
import com.clarity.spring.model.Pedido;
import com.clarity.spring.model.Producto;
import com.clarity.spring.model.Usuario;
import com.clarity.spring.service.CartService;
import com.clarity.spring.service.OrderLineService;
import com.clarity.spring.service.PedidoService;
import com.clarity.spring.service.ProductService;
import com.clarity.spring.service.UserService;

import jakarta.servlet.http.HttpSession;

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
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public String cartPage(@AuthenticationPrincipal UserDetails userDetails, Model model, @RequestParam(required = false) Long idProducto) {
		
		if(userDetails== null) {
			return "redirect: auth/login";
		}
		Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
		Pedido pedidoUsuario = this.orderService.listarPedidoUsuarioEstadoCarrito(usuario,idProducto);
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
	public String deleteOrderLine(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long lineaPedidoId) {
		
		Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
		Pedido pedidoUsuario = orderService.listarPedidoUsuarioEstadoCarrito(usuario,0L);
		System.out.println("Este es la linea que me esta llegando" + lineaPedidoId);
		LineaPedido lineaPedidoEstadoCarrito = orderLineService.buscarLineaPedidoById(lineaPedidoId);
		if(lineaPedidoEstadoCarrito != null) {
			System.out.println("la linea no es nula");
			if(pedidoUsuario.getLineasPedido().contains(lineaPedidoEstadoCarrito)) {
				System.out.println("Se va a proceder a eliminar el pedido");
				pedidoUsuario.eliminarLineaPedido(lineaPedidoEstadoCarrito);
				orderLineService.eliminarLineaPedido(lineaPedidoId);
				
			}
		}
	
		return "redirect:/cart";
	}
	
	@PostMapping("/update")
	public String updateOrderLine(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long lineaPedidoId,@RequestParam("nuevaCantidad") Long nuevaCantidad ) {
		
		Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
		Pedido pedidoUsuario = orderService.listarPedidoUsuarioEstadoCarrito(usuario, 0L);
		LineaPedido lineaPedidoEstadoCarrito = orderLineService.buscarLineaPedidoById(lineaPedidoId);
		Producto productoActualizar = lineaPedidoEstadoCarrito.getProducto();
		System.out.println("Esta es la cantidad que se esta enviando" + nuevaCantidad);
		if(lineaPedidoEstadoCarrito != null) {
			
			if(pedidoUsuario.getLineasPedido().contains(lineaPedidoEstadoCarrito)  && productService.verificarStockDisponible(productoActualizar.getProductoId()) == true ) {
				
				orderLineService.actualizarLineaPedido(lineaPedidoId,nuevaCantidad);
				}
			}
				
		return "redirect:/cart";
	}
	
	@PostMapping("/checkout")
	public String checkOutOrder(@AuthenticationPrincipal UserDetails userDetails, Model model, Long totalPedido) {
		

	    Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
	    Pedido pedidoCarrito = orderService.listarPedidoUsuarioEstadoCarrito(usuario,0L);
	    if (pedidoCarrito != null) {
	        model.addAttribute("pedidoCarrito", pedidoCarrito);  // Enviar al modelo
	        model.addAttribute("totalPedido", pedidoCarrito.calcularPrecioLineasPedido());
	        return "private/checkout";
	    }
	    
	    return "redirect:/cart";
		
	}
	
	@PostMapping("/checkout/submit")
	public String submitOrder(Model model,
			@AuthenticationPrincipal UserDetails userDetails,
			 @RequestParam String numCar,
			 @RequestParam String expiryDate,
			 @RequestParam String cvv,
			 @RequestParam String cardName) {
		System.out.println("Entramos en el metodo sumit order ");
		
		Usuario usuario = userService.getUserByEmail(userDetails.getUsername());
		Pedido pedidoCarrito = orderService.listarPedidoUsuarioEstadoCarrito(usuario,0L);
		
		 if (pedidoCarrito == null) {
			 System.out.println("Pedio es nulo ");
		        return "redirect:/cart"; 
		    }

		try {
			orderService.agregarPedidoFinalizado(usuario);
			System.out.println("Se esta ejecuanto guardar el servicio de finalizar pedido");
			return "private/checkout";
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "private/checkout";
	}
}
