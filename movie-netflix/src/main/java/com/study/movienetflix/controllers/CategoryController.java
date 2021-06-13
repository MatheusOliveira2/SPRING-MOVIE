package com.study.movienetflix.controllers;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	private CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CategoryGetDTO> newCategory(@RequestBody @Valid CategoryPostDTO category, Errors errors) {
		if(errors.hasErrors()){
			throw new BusinessException(errors.getFieldError().getDefaultMessage());
		}
		return ResponseEntity.ok(this.service.save(category));
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<CategoryGetDTO>> getCategories() {
		return ResponseEntity.ok(this.service.findAll());
	}

}
