package com.clarity.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.model.Producto;
import com.clarity.spring.service.CategoryService;
import com.clarity.spring.service.ProductService;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		List<Producto> productos = productService.listarProductos();
		model.addAttribute("productos", productos);
		return "admin/index";
	}
	@GetMapping("/add/product")
	public String formularioAgregarProducto(Model model) {
		List<Categoria> categorias = categoryService.listarCategorias();
		model.addAttribute("categorias", categorias);
		return "/admin/producto";
	}
	
	@PostMapping("/add/checkProduct")
	public String agregarProducto(Model model,
			@RequestParam String nombre,
			@RequestParam String descripcion,
			@RequestParam Double precio,
			@RequestParam Long cantidadStock,
			@RequestParam MultipartFile  imagen,
			@RequestParam String  tallasDisponibles,
			@RequestParam List<Long> categoriasIds) {
		
		
		
		productService.guardarNuevoProducto(nombre, descripcion, precio, cantidadStock, imagen,tallasDisponibles, categoriasIds);
		
		return "redirect:/admin/index";
	}
	
	@PostMapping("/delete/product/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productService.eliminarProducto(id);
		return "redirect:/admin/index";
	}
	
	@GetMapping("/update/product/{id}")
	public String formularioEditarProducto(@PathVariable Long id, Model model) {
	    Producto producto = productService.encontrarProductoById(id);
	    List<Categoria> categorias = categoryService.listarCategorias();
	    model.addAttribute("producto", producto);
	    model.addAttribute("categorias", categorias);
	    return "/admin/editarProducto";
	}

	
	@PostMapping("/update/product/{id}")
	public String editarProducto(@PathVariable Long id,
			@RequestParam String nombre,
			@RequestParam String descripcion,
			@RequestParam Double precio,
			@RequestParam Long cantidadStock,
			@RequestParam String  tallasDisponibles,
			@RequestParam List<Long> categoriasIds) {
		
		productService.editarProducto(id, nombre, descripcion, precio, cantidadStock, tallasDisponibles, categoriasIds);
		return "redirect:/admin/index";
	}
	
}
