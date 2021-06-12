package com.study.movienetflix.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.movienetflix.model.entities.Movie;

import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByName(String name);
}
