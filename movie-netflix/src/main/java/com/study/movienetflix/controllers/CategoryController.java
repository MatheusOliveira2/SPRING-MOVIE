package com.study.movienetflix.controllers;

import javax.validation.Valid;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.services.CategoryService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	private CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@PostMapping
	public CategoryGetDTO newCategory(@RequestBody @Valid CategoryPostDTO category, Errors errors) {
		if(errors.hasErrors()){
			throw new BusinessException(errors.getFieldError().getDefaultMessage());
		}
		return this.service.save(category);
	}
	
	@GetMapping
	@ResponseBody
	public List<CategoryGetDTO> getCategories() {
		return this.service.findAll();
	}

}
