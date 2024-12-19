package com.clarity.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.spring.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Long > {
	
	Optional<Usuario> findByEmailContainsIgnoreCase(String email);
	boolean existsByemail(String email);
	
}
