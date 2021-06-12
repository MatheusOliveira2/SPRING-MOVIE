package com.study.movienetflix.controllers;

import javax.validation.Valid;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

	private MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@PostMapping
	public MoviePostDTO newMovie(@RequestBody @Valid MoviePostDTO movie, Errors errors) {
		if(errors.hasErrors()){
			throw new BusinessException(errors.getFieldError().getDefaultMessage());
		}
		service.save(movie);
		return movie;
	}
	
	@GetMapping
	public List<MovieGetDTO> getMovies(){
		return service.findAll();
	}
}
