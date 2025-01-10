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
	
	
	@Bean
	CommandLineRunner initCategory(CategoryRepository categoryRepository) {
		return (args)->{
			
		    Categoria ropa = new Categoria(null, "Ropa", "Categoría general de ropa");
		    Categoria calzado = new Categoria(null, "Calzado", "Zapatillas y zapatos de todo tipo");
		    Categoria accesorios = new Categoria(null, "Accesorios", "Complementos y accesorios");
		    Categoria invierno = new Categoria(null, "Invierno", "Ropa y accesorios para el frío");
		    
			categoryRepository.save(ropa);
			categoryRepository.save(calzado);
			categoryRepository.save(accesorios);
			categoryRepository.save(invierno);
			
		};
	}
	
	@Bean
	CommandLineRunner initProduct(ProductRepository	productRepository, CategoryRepository categoryRepository ) {
		return (args) ->{
			
			Producto camisetaAzul = new Producto(1L, 24.99, "camiseta-azul.jpg", "Camiseta básica de algodón", "Camiseta Azul", 50L);
		    Producto zapatillasBlancas = new Producto(2L, 59.99, "zapatillas-blancas.jpg", "Zapatillas deportivas blancas", "Zapatillas Blancas", 30L);
		    Producto guantesNegros = new Producto(3L, 14.99, "guantes-negros.jpg", "Guantes de lana negros", "Guantes Negros", 25L);
		    Producto chaquetaInvierno = new Producto(4L, 89.99, "chaqueta-invierno.jpg", "Chaqueta acolchada de invierno", "Chaqueta Invierno", 20L);
		    

		    
		    camisetaAzul.getCategorias().add(categoryRepository.findByNombre("Ropa"));
		
		    productRepository.save(camisetaAzul);	
		    productRepository.save(zapatillasBlancas);
		    productRepository.save(guantesNegros);
		    productRepository.save(chaquetaInvierno);
	    
		};
	}
		
	

}

