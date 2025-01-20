package com.clarity.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clarity.spring.model.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto,Long> {
	
	Producto findByNombre(String name);
	Producto findByProductoId(Long idProducto);
	
	@Query("SELECT DISTINCT p FROM Producto p " +
	        "JOIN p.categorias c " +
	        "WHERE " +
	        "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
	        "(:categoriaId IS NULL OR c.categoria_id = :categoriaId) AND " +
	        "(:precioMin IS NULL OR p.precio >= :precioMin) AND " +
	        "(:precioMax IS NULL OR p.precio <= :precioMax)")
	List<Producto> findByFilters(
	        @Param("nombre") String nombre,
	        @Param("categoriaId") Long categoriaId,
	        @Param("precioMin") Double precioMin,
	        @Param("precioMax") Double precioMax);

	
}


