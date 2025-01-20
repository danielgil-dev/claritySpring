package com.clarity.spring.repository;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clarity.spring.model.Categoria;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {
	
	 @Query("SELECT c FROM Categoria c")
	 List<Categoria> findAllCategories();
	 Categoria findByNombre(String nombre);
	
	
	

}
