package com.study.movienetflix.services;

import com.study.movienetflix.controllers.CategoryController;
import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

//@WebMvcTest(controllers = CategoryService.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryRepository repository;

    @Test
    public void save(){
        CategoryPostDTO dto = new CategoryPostDTO();
        dto.setName("CategoryTest");
        Category category = new Category();
        category.setId(3);
        category.setName("CategoryTest");
        Mockito.when(repository.save(Mockito.any(Category.class))).thenReturn(category);
        CategoryGetDTO result =  service.save(dto);
        Assert.assertEquals(category.getName(), result.getName());
        Assert.assertEquals(category.getId(), result.getId());
    }

    @Test
    public void findAll(){
        Category category = new Category();
        category.setId(3);
        category.setName("CategoryTest");
        List<Category> list = new ArrayList();
        list.add(category);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<CategoryGetDTO> listResult = service.findAll();
        Assert.assertEquals(category.getName(), listResult.get(0).getName());
        Assert.assertEquals(category.getId(), listResult.get(0).getId());
    }

}
