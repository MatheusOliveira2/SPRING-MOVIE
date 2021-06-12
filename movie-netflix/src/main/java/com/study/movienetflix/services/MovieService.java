package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.repositories.MovieRepository;
import com.study.movienetflix.util.MessageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {


    private MovieRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public MovieGetDTO save(MoviePostDTO dto){
        Optional<Movie> optionalMovie = repository.findByName(dto.getName());
        if(optionalMovie.isPresent()){
            throw new BusinessException(MessageUtils.MOVIE_ALREADY_EXISTS);
        }
        Movie entity = mapper.map(dto, Movie.class);
        Movie movie = repository.save(entity);
        return mapper.map(movie, MovieGetDTO.class);
    }

    @Transactional(readOnly = true)
    public List<MovieGetDTO> findAll(){
        List<Movie> list = repository.findAll();
        return list.stream().map(movie -> mapper.map(movie, MovieGetDTO.class)).collect(Collectors.toList());
    }
}
