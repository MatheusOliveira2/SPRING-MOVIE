package com.study.movienetflix.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.study.movienetflix.model.entities.Movie;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
