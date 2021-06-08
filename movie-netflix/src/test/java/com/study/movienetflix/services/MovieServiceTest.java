package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.entities.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
public class MovieServiceTest {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    MovieService service;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void save(){
        MoviePostDTO dto = new MoviePostDTO();
        dto.setName("nomejgjg");
        dto.setDuration("1:50");
        dto.setSynopsis("Sinopse");
        dto.setPictureURL("Foto");
        dto.setCategory(new Category());

        Movie entity = mapper.map(dto, Movie.class);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getDuration(), dto.getDuration());
        Assert.assertEquals(entity.getPictureURL(), dto.getPictureURL());
        Assert.assertEquals(entity.getCategory(), dto.getCategory());
    }

    @Test
    public void findAll(){
        List<MovieGetDTO> list = service.findAll();
        Assert.assertTrue(list.size() >= 0);
    }
}
