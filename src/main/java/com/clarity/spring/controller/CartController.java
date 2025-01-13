package com.clarity.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarity.spring.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public String cartPage(@AuthenticationPrincipal UserDetails userDetails, Model model ) {
		
		if(userDetails== null) {
			return "redirect: auth/login";
		}
		String usuario = userDetails.getUsername();
		model.addAttribute("usuario", usuario);
		return "public/cart";
	}
	
	@PostMapping("/add")
	public String addToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long idProducto) {
		
		if(userDetails == null) {
			return "redirect: auth/login";
		}
		cartService.agregarProdutoAcarrito(userDetails.getUsername(), idProducto);
		return "redirect:/cart";
	}
}
