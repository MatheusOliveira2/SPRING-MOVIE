package com.study.movienetflix.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.movienetflix.model.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
