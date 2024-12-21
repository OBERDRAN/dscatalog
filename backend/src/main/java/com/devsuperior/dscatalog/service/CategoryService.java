package com.devsuperior.dscatalog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> listCategoryEntity = repository.findAll();
		
		//converter usando expressão lambda
		return listCategoryEntity.stream().map(x-> new CategoryDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findbyId(Long id){
		
		//Category categoryentity = repository.findById(id).get();
		
		//CategoryDTO categorydto = new CategoryDTO(categoryentity);
		
		//return categorydto;
		
		Optional<Category> objOptional = repository.findById(id);
		
		Category categoryentity = objOptional.get();
		
		return new CategoryDTO(categoryentity);
		
	}
}
