package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.model.entities.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    CategoryService service;

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
