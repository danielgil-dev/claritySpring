package com.clarity.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.Categoria;
import com.clarity.spring.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Categoria> listarCategorias(){
		
		List<Categoria> categorias = categoryRepository.findAllCategories();
		return categorias;
	}
	

}
