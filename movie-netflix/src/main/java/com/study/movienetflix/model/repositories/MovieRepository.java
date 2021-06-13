package com.study.movienetflix.model.repositories;

import com.study.movienetflix.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByName(String name);
}
