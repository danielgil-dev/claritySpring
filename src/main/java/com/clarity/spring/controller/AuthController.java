package com.clarity.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clarity.spring.model.Usuario;
import com.clarity.spring.service.UserService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model){
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			  result.getFieldErrors().forEach(error -> {
			        System.out.println("Campo: " + error.getField());
			        System.out.println("Error: " + error.getDefaultMessage());
			    });
			model.addAttribute(usuario);
			return "register";
		}
		try {
			userService.registerUser(usuario.getNombre(), usuario.getApellido(), usuario.getDireccion(), usuario.getEmail(), usuario.getContrasenya(), usuario.getTelefono());
			return "redirect:/auth/login";
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "register";
	}
}
