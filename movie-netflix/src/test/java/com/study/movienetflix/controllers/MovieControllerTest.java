package com.study.movienetflix.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.services.MovieService;
import com.study.movienetflix.services.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

@WebMvcTest(controllers = MovieController.class)
@RunWith(SpringRunner.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void newRoleSuccess() throws Exception {
        MoviePostDTO dto = new MoviePostDTO();
        dto.setDuration("duration");
        dto.setName("name");
        dto.setSynopsis("synopsis");
        dto.setPictureURL("url");
        Category category = new Category();
        category.setId(1);
        category.setName("Horror");
        dto.setCategory(category);

        MovieGetDTO getDto = new MovieGetDTO();
        getDto.setDuration("duration");
        getDto.setName("name");
        getDto.setSynopsis("synopsis");
        getDto.setPictureURL("url");
        getDto.setId(3);
        getDto.setCategory(category);

        Mockito.when(movieService.save(Mockito.any(MoviePostDTO.class))).thenReturn(getDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/movie").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(getDto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",is(getDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.duration",is(getDto.getDuration())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.synopsis",is(getDto.getSynopsis())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pictureURL",is(getDto.getPictureURL())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category.name",is(getDto.getCategory().getName())));
    }

    @Test
    void newRoleSuccessException() throws Exception {
        MoviePostDTO dto = new MoviePostDTO();
        dto.setDuration("");
        dto.setName("name");
        dto.setSynopsis("synopsis");
        dto.setPictureURL("url");
        Category category = new Category();
        category.setId(1);
        category.setName("Horror");
        dto.setCategory(null);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/movie").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message",is(instanceOf(String.class))));
    }

    @Test
    void getMovies() throws Exception {
        MovieGetDTO dto = new MovieGetDTO();
        dto.setId(3);
        dto.setDuration("duration");
        dto.setName("name");
        dto.setSynopsis("synopsis");
        dto.setPictureURL("url");
        Category category = new Category();
        category.setId(1);
        category.setName("Horror");
        dto.setCategory(category);
        List<MovieGetDTO> list = new ArrayList();
        list.add(dto);
        Mockito.when(movieService.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/movie")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(dto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",is(dto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].duration",is(dto.getDuration())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].synopsis",is(dto.getSynopsis())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pictureURL",is(dto.getPictureURL())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category.name",is(dto.getCategory().getName())));
    }
}


