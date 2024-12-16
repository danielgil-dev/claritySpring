package com.clarity.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.spring.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Long > {
	
	List<Usuario> findByEmailContainsIgnoreCase(String email);
	
}
