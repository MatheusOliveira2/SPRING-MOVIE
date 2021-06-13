package com.study.movienetflix.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = CategoryController.class)
@RunWith(SpringRunner.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void newCategorySuccess() throws Exception {
        CategoryPostDTO dto = new CategoryPostDTO();
        dto.setName("CategoryTeste");
        CategoryGetDTO getDto = new CategoryGetDTO();
        getDto.setId(3);
        getDto.setName("CategoryTeste");
        Mockito.when(categoryService.save(dto)).thenReturn(getDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/category").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",is(dto.getName())));
    }

    @Test
    public void newCategoryException() throws Exception {
        CategoryPostDTO dto = new CategoryPostDTO();
        dto.setName("");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/category").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message",is("*Please provide a not empty name")));
    }

    @Test
    public void getCategoriesSuccess() throws Exception {
        CategoryGetDTO dto = new CategoryGetDTO();
        dto.setId(3);
        dto.setName("CategoryTeste");
        List<CategoryGetDTO> list = new ArrayList();
        list.add(dto);
        Mockito.when(categoryService.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/category")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(dto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",is(dto.getName())));
    }
}