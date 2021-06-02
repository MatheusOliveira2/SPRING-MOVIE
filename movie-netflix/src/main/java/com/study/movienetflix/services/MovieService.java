package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<MoviePostDTO> findAll(){
        List<Movie> list = repository.findAll();
        System.out.println("Aquiiiiiiiiiiiiiiiiiiiii");
        return list.stream().map(movie -> mapper.map(movie, MoviePostDTO.class)).collect(Collectors.toList());
    }
}
