//package com.clarity.spring.initializer;
//
//import java.util.Arrays;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.clarity.spring.model.Categoria;
//import com.clarity.spring.model.Producto;
//import com.clarity.spring.repository.CategoryRepository;
//import com.clarity.spring.repository.ProductRepository;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//
//    public DataInitializer(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Paso 1: Guardar productos
//        guardarProductos();
//
//        // Paso 2: Guardar categorías
//        guardarCategorias();
//
//        // Paso 3: Establecer relaciones entre productos y categorías
//        establecerRelaciones();
//    }
//
//    private void guardarProductos() {
//        Producto camisetaAzul = new Producto(null, 24.99, "camiseta-azul.jpg", "Camiseta básica de algodón", "Camiseta Azul", 50L);
//        Producto zapatillasBlancas = new Producto(null, 59.99, "zapatillas-blancas.jpg", "Zapatillas deportivas blancas", "Zapatillas Blancas", 30L);
//        Producto guantesNegros = new Producto(null, 14.99, "guantes-negros.jpg", "Guantes de lana negros", "Guantes Negros", 25L);
//        Producto chaquetaInvierno = new Producto(null, 89.99, "chaqueta-invierno.jpg", "Chaqueta acolchada de invierno", "Chaqueta Invierno", 20L);
//
//        productRepository.saveAll(Arrays.asList(camisetaAzul, zapatillasBlancas, guantesNegros, chaquetaInvierno));
//
//        System.out.println("Productos guardados.");
//    }
//
//    private void guardarCategorias() {
//        Categoria ropa = new Categoria(null, "Ropa", "Categoría general de ropa");
//        Categoria calzado = new Categoria(null, "Calzado", "Zapatillas y zapatos de todo tipo");
//        Categoria accesorios = new Categoria(null, "Accesorios", "Complementos y accesorios");
//        Categoria invierno = new Categoria(null, "Invierno", "Ropa y accesorios para el frío");
//
//        categoryRepository.saveAll(Arrays.asList(ropa, calzado, accesorios, invierno));
//
//        System.out.println("Categorías guardadas.");
//    }
//
//    private void establecerRelaciones() {
//        // Recuperar productos
//        Producto camisetaAzul = productRepository.findByNombre("Camiseta Azul");
//        Producto zapatillasBlancas = productRepository.findByNombre("Zapatillas Blancas");
//        Producto guantesNegros = productRepository.findByNombre("Guantes Negros");
//        Producto chaquetaInvierno = productRepository.findByNombre("Chaqueta Invierno");
//
//        // Recuperar categorías
//        Categoria ropa = categoryRepository.findByNombre("Ropa");
//        Categoria calzado = categoryRepository.findByNombre("Calzado");
//        Categoria accesorios = categoryRepository.findByNombre("Accesorios");
//        Categoria invierno = categoryRepository.findByNombre("Invierno");
//
//        // Establecer relaciones
//        camisetaAzul.getCategorias().add(ropa);
//        zapatillasBlancas.getCategorias().addAll(Arrays.asList(calzado, ropa));
//        guantesNegros.getCategorias().addAll(Arrays.asList(accesorios, invierno));
//        chaquetaInvierno.getCategorias().add(invierno);
//
//        ropa.getProductos().addAll(Arrays.asList(camisetaAzul, zapatillasBlancas));
//        calzado.getProductos().add(zapatillasBlancas);
//        accesorios.getProductos().add(guantesNegros);
//        invierno.getProductos().addAll(Arrays.asList(guantesNegros, chaquetaInvierno));
//
//        // Guardar relaciones en la base de datos
//        productRepository.saveAll(Arrays.asList(camisetaAzul, zapatillasBlancas, guantesNegros, chaquetaInvierno));
//        categoryRepository.saveAll(Arrays.asList(ropa, calzado, accesorios, invierno));
//
//        System.out.println("Relaciones establecidas.");
//    }
//}
