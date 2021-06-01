package com.study.movienetflix.controllers;

import javax.validation.Valid;

import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.movienetflix.model.entities.Movie;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@PostMapping
	public MoviePostDTO newMovie(@RequestBody @Valid MoviePostDTO movie) {
		service.save(movie);
		return movie;
	}
	
//	@GetMapping
//	public Iterable<Movie> getMovies(){
//		return service.findAll();
//	}
}
