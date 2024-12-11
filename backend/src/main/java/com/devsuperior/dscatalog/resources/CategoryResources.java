package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;

@RestController
@RequestMapping("/categorias")
public class CategoryResources {

	//encapsula uma resposta http
	public ResponseEntity<List<Category>> findAll(){
		List<Category>list = new ArrayList<>();
		list.add(new Category(1L, "Livros"));
		list.add(new Category(2L, "Eletonicos"));
		
		return ResponseEntity.ok().body(list);
	}
}
