package com.clarity.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.model.Producto;
import com.clarity.spring.repository.CategoryRepository;
import com.clarity.spring.repository.ProductRepository;

@SpringBootApplication
public class ClarityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClarityApplication.class, args);
	}
	

	/*
	@Bean
	CommandLineRunner initData(CategoryRepository categoryRepository,ProductRepository	productRepository) {
		return (args)->{
			
		    Categoria ropa = new Categoria(null, "Ropa", "Categoría general de ropa");
		    Categoria calzado = new Categoria(null, "Calzado", "Zapatillas y zapatos de todo tipo");
		    Categoria accesorios = new Categoria(null, "Accesorios", "Complementos y accesorios");
		    Categoria invierno = new Categoria(null, "Invierno", "Ropa y accesorios para el frío");
		    
		    categoryRepository.saveAll(List.of(ropa,calzado,accesorios,invierno));
			
			
			Producto camisetaAzul = new Producto(null, 24.99, "camiseta-azul.png", "Camiseta básica de algodón", "Camiseta Azul", 50L);
			camisetaAzul.setTallasDisponibles(List.of("S", "M", "L", "XL", "XXL")); // Asignar tallas
	        
		    Producto zapatillasBlancas = new Producto(null, 59.99, "zapatillas-blancas.png", "Zapatillas deportivas blancas", "Zapatillas Blancas", 30L);
			zapatillasBlancas.setTallasDisponibles(List.of("40", "41", "42", "43", "44")); // Asignar tallas
			
		    Producto guantesNegros = new Producto(null, 14.99, "guantes-marron.png", "Guantes de lana marron", "Guantes marron", 25L);
			guantesNegros.setTallasDisponibles(List.of("S", "M", "L", "XL", "XXL")); // Asignar tallas
			
		    Producto chaquetaInvierno = new Producto(null, 89.99, "chaqueta-verde.png", "Chaqueta acolchada de invierno", "Chaqueta Invierno", 20L);
			chaquetaInvierno.setTallasDisponibles(List.of("S", "M", "L", "XL", "XXL")); // Asignar tallas
		    
		    productRepository.saveAll(List.of(camisetaAzul,zapatillasBlancas,guantesNegros,chaquetaInvierno));
		    
		    camisetaAzul.addCategoria(ropa);
		    zapatillasBlancas.addCategoria(ropa);
		    guantesNegros.addCategoria(ropa);
		    guantesNegros.addCategoria(invierno);
		    chaquetaInvierno.addCategoria(ropa);
		    chaquetaInvierno.addCategoria(invierno);
	        
	       
			productRepository.saveAll(List.of(camisetaAzul, guantesNegros, chaquetaInvierno,zapatillasBlancas));
			
			
		};
	}
*/
	

}

