package com.study.movienetflix.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.repositories.MovieRepository;

@RestController
@RequestMapping(path = "/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@PostMapping
	public Movie newMovie(@RequestBody @Valid Movie movie) {
		movieRepository.save(movie);
		return movie;
	}
}
