package com.study.movienetflix.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping
	public Category newCategory(@Valid @RequestBody Category category) {
		this.categoryRepository.save(category);
		return category;
	}
	
	public Iterable<Category> getCategories() {
		return this.categoryRepository.findAll();
	}
}
