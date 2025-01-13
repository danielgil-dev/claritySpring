package com.clarity.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.spring.model.Pedido;

public interface OrderRepository extends JpaRepository<Pedido, Long > {
	
	
}
