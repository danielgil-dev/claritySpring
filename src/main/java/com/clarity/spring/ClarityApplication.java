package com.clarity.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.model.Producto;
import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.CategoryRepository;
import com.clarity.spring.repository.ProductRepository;
import com.clarity.spring.repository.UserRepository;

@SpringBootApplication
public class ClarityApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ClarityApplication.class, args);
	}
	

	/*
	@Bean
	CommandLineRunner initData(CategoryRepository categoryRepository,ProductRepository	productRepository) {
		return (args)->{
				
			Usuario usuarioAdministrador = new Usuario ();
			usuarioAdministrador.setNombre("Daniel");
			usuarioAdministrador.setApellido("Gil");
			usuarioAdministrador.setDireccion("Calle 133");
			usuarioAdministrador.setEmail("danielAdmin@gmail.com");
			usuarioAdministrador.setContrasenya(passwordEncoder.encode("admin123"));
			usuarioAdministrador.setDni("29151244D");
			usuarioAdministrador.setTelefono("655622212");
			usuarioAdministrador.setRole("ADMIN");
			userRepository.save(usuarioAdministrador);
		
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
	
	
	@Bean
	CommandLineRunner initData(CategoryRepository categoryRepository, ProductRepository productRepository) {
	    return (args) -> {
	    	
	    	Usuario usuarioAdministrador = new Usuario ();
			usuarioAdministrador.setNombre("Daniel");
			usuarioAdministrador.setApellido("Gil");
			usuarioAdministrador.setDireccion("Calle 133");
			usuarioAdministrador.setEmail("danielAdmin@gmail.com");
			usuarioAdministrador.setContrasenya(passwordEncoder.encode("admin123"));
			usuarioAdministrador.setDni("29151244D");
			usuarioAdministrador.setTelefono("655622212");
			usuarioAdministrador.setRole("ADMIN");
			userRepository.save(usuarioAdministrador);
	        // Crear categorías
	        Categoria ropa = new Categoria(null, "Ropa", "Categoría general de ropa");
	        Categoria calzado = new Categoria(null, "Calzado", "Zapatillas y zapatos de todo tipo");
	        Categoria accesorios = new Categoria(null, "Accesorios", "Complementos y accesorios");
	        Categoria invierno = new Categoria(null, "Invierno", "Ropa y accesorios para el frío");

	        categoryRepository.saveAll(List.of(ropa, calzado, accesorios, invierno));

	        // Crear productos
	        Producto camisetaAzul = new Producto(null, 24.99, "Camiseta-Azul.png", "Camiseta azul de algodón", "Camiseta Azul", 50L);
	        camisetaAzul.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        camisetaAzul.setCategorias(List.of(ropa));

	        Producto camisetaBeige = new Producto(null, 22.99, "camiseta-beige.png", "Camiseta beige de algodón", "Camiseta Beige", 45L);
	        camisetaBeige.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        camisetaBeige.setCategorias(List.of(ropa));

	        Producto camisetaAzulMangaLarga = new Producto(null, 29.99, "Camiseta-Azul-Manga-larga.png", "Camiseta azul de manga larga", "Camiseta Azul Manga Larga", 30L);
	        camisetaAzulMangaLarga.setTallasDisponibles(List.of("M", "L", "XL"));
	        camisetaAzulMangaLarga.setCategorias(List.of(ropa, invierno));

	        Producto pantalonNegro = new Producto(null, 34.99, "pantalon-negro.png", "Pantalón negro ajustado", "Pantalón Negro", 40L);
	        pantalonNegro.setTallasDisponibles(List.of("30", "32", "34", "36"));
	        pantalonNegro.setCategorias(List.of(ropa));

	        Producto chaquetaVerde = new Producto(null, 89.99, "chaqueta-verde.png", "Chaqueta acolchada verde para invierno", "Chaqueta Verde", 20L);
	        chaquetaVerde.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        chaquetaVerde.setCategorias(List.of(ropa, invierno));

	        Producto chaquetaMarron = new Producto(null, 84.99, "chaqueta-marron.png", "Chaqueta marrón clásica", "Chaqueta Marrón", 15L);
	        chaquetaMarron.setTallasDisponibles(List.of("S", "M", "L"));
	        chaquetaMarron.setCategorias(List.of(ropa, invierno));

	        Producto zapatillasBlancas = new Producto(null, 59.99, "zapatillas-blancas.png", "Zapatillas deportivas blancas", "Zapatillas Blancas", 30L);
	        zapatillasBlancas.setTallasDisponibles(List.of("40", "41", "42", "43", "44"));
	        zapatillasBlancas.setCategorias(List.of(calzado));

	        Producto zapatillasNegras = new Producto(null, 64.99, "zapatillas-negras.png", "Zapatillas deportivas negras", "Zapatillas Negras", 25L);
	        zapatillasNegras.setTallasDisponibles(List.of("39", "40", "41", "42"));
	        zapatillasNegras.setCategorias(List.of(calzado));

	        Producto glovesBlack = new Producto(null, 14.99, "gloves-black.png", "Guantes negros de lana", "Guantes Negros", 35L);
	        glovesBlack.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        glovesBlack.setCategorias(List.of(invierno, accesorios));

	        Producto glovesBrown = new Producto(null, 16.99, "gloves-brown.png", "Guantes marrones clásicos", "Guantes Marrones", 20L);
	        glovesBrown.setTallasDisponibles(List.of("S", "M", "L"));
	        glovesBrown.setCategorias(List.of(invierno, accesorios));

	        Producto gorraAzul = new Producto(null, 9.99, "gorra-azul.png", "Gorra azul para el verano", "Gorra Azul", 50L);
	        gorraAzul.setTallasDisponibles(List.of("Talla Única"));
	        gorraAzul.setCategorias(List.of(accesorios));

	        Producto gorraNegra = new Producto(null, 10.99, "gorra-negra.png", "Gorra negra ajustable", "Gorra Negra", 45L);
	        gorraNegra.setTallasDisponibles(List.of("Talla Única"));
	        gorraNegra.setCategorias(List.of(accesorios));

	        Producto poloBeige = new Producto(null, 24.99, "polo-beige.png", "Polo beige de algodón", "Polo Beige", 35L);
	        poloBeige.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        poloBeige.setCategorias(List.of(ropa));

	        Producto shortNegro = new Producto(null, 19.99, "short-black.png", "Short negro para deportes", "Short Negro", 40L);
	        shortNegro.setTallasDisponibles(List.of("S", "M", "L", "XL"));
	        shortNegro.setCategorias(List.of(ropa));

	        Producto shortBeige = new Producto(null, 18.99, "short-beige.png", "Short beige casual", "Short Beige", 38L);
	        shortBeige.setTallasDisponibles(List.of("S", "M", "L"));
	        shortBeige.setCategorias(List.of(ropa));

	        // Guardar productos
	        productRepository.saveAll(List.of(
	            camisetaAzul, camisetaBeige, camisetaAzulMangaLarga, pantalonNegro,
	            chaquetaVerde, chaquetaMarron, zapatillasBlancas, zapatillasNegras,
	            glovesBlack, glovesBrown, gorraAzul, gorraNegra,
	            poloBeige, shortNegro, shortBeige
	        ));
	    };
	}

	*/

}

