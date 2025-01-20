package com.clarity.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clarity.spring.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("categorias", categoryService.listarCategorias());
		return "public/index";
	}
	
	
	
}
