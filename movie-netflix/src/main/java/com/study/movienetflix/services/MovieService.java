package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    private ModelMapper mapper = new ModelMapper();


    @Transactional
    public MoviePostDTO save(MoviePostDTO dto){
        Movie entity = mapper.map(dto, Movie.class);
        repository.save(entity);
        return dto;
    }
}
