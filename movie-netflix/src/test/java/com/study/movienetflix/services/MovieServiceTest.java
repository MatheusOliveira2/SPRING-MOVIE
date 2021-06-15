package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.repositories.MovieRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceTest {

    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository repository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveSuccess(){
        MoviePostDTO dto = new MoviePostDTO();
        dto.setName("name");
        dto.setPictureURL("url");
        dto.setSynopsis("Synopsis");
        dto.setDuration("duration");
        dto.setCategory(new Category());
        Movie movie = new Movie();
        movie.setName("name");
        movie.setPictureURL("url");
        movie.setSynopsis("Synopsis");
        movie.setDuration("duration");
        movie.setId(3);
        Mockito.when(repository.save(Mockito.any(Movie.class))).thenReturn(movie);
        MovieGetDTO result =  service.save(dto);
        Assert.assertEquals(movie.getName(), result.getName());
        Assert.assertEquals(movie.getId(), result.getId());
    }

    @Test
    public void saveAlreadyInsertedValue(){
        MoviePostDTO dto = new MoviePostDTO();
        dto.setName("name");
        dto.setPictureURL("url");
        dto.setSynopsis("Synopsis");
        dto.setDuration("duration");
        dto.setCategory(new Category());

        Optional<Movie> movieResult = Optional.of(new Movie());
        Mockito.when(repository.findByName(Mockito.any(String.class))).thenReturn(movieResult);
        Assertions.assertThrows(BusinessException.class,() ->{
            MovieGetDTO result =  service.save(dto);
        });
    }

    @Test
    public void findAll(){
        Movie movie = new Movie();
        movie.setName("name");
        movie.setPictureURL("url");
        movie.setSynopsis("Synopsis");
        movie.setDuration("duration");
        movie.setId(3);
        List<Movie> list = new ArrayList();
        list.add(movie);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<MovieGetDTO> listResult = service.findAll();
        Assert.assertEquals(movie.getName(), listResult.get(0).getName());
        Assert.assertEquals(movie.getId(), listResult.get(0).getId());
    }
}
