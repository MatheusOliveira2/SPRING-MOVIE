package com.study.movienetflix.controllers;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.services.MovieService;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<MovieGetDTO> newMovie(@RequestBody @Valid MoviePostDTO movie, Errors errors) {
		if(errors.hasErrors()){
			throw new BusinessException(errors.getFieldError().getDefaultMessage());
		}

		return ResponseEntity.ok(service.save(movie));
	}
	
	@GetMapping
	public ResponseEntity<List<MovieGetDTO>> getMovies(){
		return ResponseEntity.ok(service.findAll());
	}
}
