package com.study.movienetflix.controllers;

import javax.validation.Valid;

import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	private CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@PostMapping
	public CategoryPostDTO newCategory(@RequestBody @Valid CategoryPostDTO category) {
		this.service.save(category);
		return category;
	}
	
	@GetMapping
	@ResponseBody
	public List<CategoryGetDTO> getCategories() {
		return this.service.findAll();
	}

}
