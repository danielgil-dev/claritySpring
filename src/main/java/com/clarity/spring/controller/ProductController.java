package com.clarity.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.model.Producto;
import com.clarity.spring.service.CategoryService;
import com.clarity.spring.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private  ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/products")
	public String productPage(Model model) {
		List<Producto> listaProductos = this.productService.listarProductos();
		model.addAttribute("productos", listaProductos);
		return "public/products";
	}
	
	 @GetMapping("/search")
	 public String searchProducts(
	            @RequestParam(value = "nombre", required = false) String nombre,
	            @RequestParam(value = "categoria", required = false) Long categoriaId,
	            @RequestParam(value = "precioMin", required = false) Double precioMin,
	            @RequestParam(value = "precioMax", required = false) Double precioMax,
	            Model model) {
	        
	        // Lógica para buscar productos
	        
		 	List<Producto> productos = productService.buscarProducto(nombre, categoriaId, precioMin, precioMax);

	       // Pasar los productos encontrados al modelo
	        model.addAttribute("productos", productos);
	        System.out.println("Se encontraron la cantidad de  " + productos.size());

	        // Pasar las categorías también para mantenerlas disponibles
	        List<Categoria> categorias = categoryService.listarCategorias();
	        model.addAttribute("categorias", categorias);
	        model.addAttribute("resultado", productos.size());

	        return "public/index"; 
	    }
	

}
