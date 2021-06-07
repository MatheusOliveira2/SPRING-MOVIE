package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
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
public class CategoryServiceTest {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    CategoryService service;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void save(){
        CategoryPostDTO dto = new CategoryPostDTO();
        dto.setName("nome");

        Category entity = mapper.map(dto, Category.class);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    @Test
    public void findAll(){
        List<CategoryGetDTO> list = service.findAll();
        Assert.assertTrue(list.size() >= 0);
    }

}
