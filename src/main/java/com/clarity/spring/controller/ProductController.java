package com.clarity.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clarity.spring.model.Producto;
import com.clarity.spring.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private  ProductService productService;
	
	@GetMapping("/products")
	public String productPage(Model model) {
		List<Producto> listaProductos = this.productService.listarProductos();
		model.addAttribute("productos", listaProductos);
		return "public/products";
	}
	

}
