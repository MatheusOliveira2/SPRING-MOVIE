package com.study.movienetflix.controllers;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.services.MovieService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
