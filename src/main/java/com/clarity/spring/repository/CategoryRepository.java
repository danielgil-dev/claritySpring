package com.clarity.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clarity.spring.model.Categoria;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {
	
	Categoria findByNombre(String nombre);

}
