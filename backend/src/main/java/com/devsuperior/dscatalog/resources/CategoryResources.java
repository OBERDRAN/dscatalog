package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.service.CategoryService;

@RestController
@RequestMapping("/categorias")
public class CategoryResources {

	@Autowired
	private CategoryService service;
	
	//encapsula uma resposta http
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		
		List<CategoryDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CategoryDTO>findById(@PathVariable("id")Long id ){
		
		//return ResponseEntity.ok().body(service.findbyId(id));

		CategoryDTO dto = service.findbyId(id);
		
		return ResponseEntity.ok().body(dto);
		
	}
}
