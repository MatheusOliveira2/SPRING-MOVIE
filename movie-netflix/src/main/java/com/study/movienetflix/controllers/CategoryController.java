package com.study.movienetflix.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping
	public Category newCategory(@RequestBody @Valid Category category) {
		this.categoryRepository.save(category);
		return category;
	}
	
	@GetMapping
	@ResponseBody
	public Iterable<Category> getCategories() {
		return this.categoryRepository.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public void removeCategory(@PathVariable int id) {
		this.categoryRepository.deleteById(id);
	}
}
