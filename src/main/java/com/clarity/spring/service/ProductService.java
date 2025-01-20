package com.clarity.spring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.model.Producto;
import com.clarity.spring.repository.CategoryRepository;
import com.clarity.spring.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Producto> listarProductos() {

		return this.productRepository.findAll();
	}

	public Boolean verificarStockDisponible(Long idProducto) {

		Producto producto = productRepository.findByProductoId(idProducto);
		return producto.getCantidad_stock() > 0 ? true : false;
	}

	public Producto encontrarProductoById(Long idProducto) {

		return productRepository.findByProductoId(idProducto);

	}

	public List<Producto> buscarProducto(String nombre, Long categoriaId, Double precioMin, Double precioMax) {

		return productRepository.findByFilters(nombre, categoriaId, precioMin, precioMax);
	}
	
	public void editarProducto(Long idProducto,String nombre, String descripcion, Double precio, Long cantidadStock, String tallasDisponibles,List<Long> categoriasIds ) {

		
			Producto productoEditado = productRepository.findById(idProducto)
					.orElseThrow(() -> new IllegalArgumentException("El producto con ID " + idProducto + " no existe."));
			
			productoEditado.setNombre(nombre);
			productoEditado.setCantidad_stock(cantidadStock);
			productoEditado.setDescripcion(descripcion);
			productoEditado.setNombre(nombre);
			productoEditado.setTallasDisponibles(new ArrayList<>(Arrays.asList(tallasDisponibles.split(","))));

			List<Categoria> categorias = new ArrayList<>(categoryRepository.findAllById(categoriasIds));
			productoEditado.setCategorias(categorias);
			productRepository.save(productoEditado);
		
	}

	public void eliminarProducto(Long idProducto) {
		
		if(productRepository.existsById(idProducto)) {
			productRepository.deleteById(idProducto);
		}
		
	}
	
	public void guardarNuevoProducto(String nombre, String descripcion, Double precio, Long cantidadStock,
			MultipartFile imagen, String tallasDisponibles, List<Long> categoriasIds) {

		Producto nuevoProducto = new Producto();
		nuevoProducto.setNombre(nombre);
		nuevoProducto.setDescripcion(descripcion);
		nuevoProducto.setPrecio(precio);
		nuevoProducto.setCantidad_stock(cantidadStock);
		nuevoProducto.setTallasDisponibles(Arrays.asList(tallasDisponibles.split(",")));

		List<Categoria> categorias = categoryRepository.findAllById(categoriasIds);
		nuevoProducto.setCategorias(categorias);
		nuevoProducto.setImagen(guardarImagen(imagen));
		productRepository.save(nuevoProducto);
	}

	private String guardarImagen(MultipartFile archivo) {
	    if (archivo.isEmpty()) {
	        throw new IllegalArgumentException("El archivo de imagen no puede estar vacío");
	    }
	    try {
	   
	        String rutaCarpeta = System.getProperty("user.dir") + "/uploads";

	      
	        String nombreArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename();

	        
	        Path rutaArchivo = Paths.get(rutaCarpeta, nombreArchivo);

	     
	        if (!Files.exists(rutaArchivo.getParent())) {
	            Files.createDirectories(rutaArchivo.getParent());
	        }

	       
	        archivo.transferTo(rutaArchivo.toFile());

	        return nombreArchivo;
	    } catch (IOException e) {
	        throw new RuntimeException("Error al guardar la imagen", e);
	    }
	}

}
