package com.devsuperior.dscatalog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.service.exceptions.EntidadeNotFoundException;

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
		
		Category categoryentity = objOptional.orElseThrow(()->new EntidadeNotFoundException("Entity Nof Found"));
		
		return new CategoryDTO(categoryentity);
		
	}
	
	@Transactional
	public CategoryDTO create(CategoryDTO dto) {
		
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);

		return new CategoryDTO(entity);
	}
	
}
