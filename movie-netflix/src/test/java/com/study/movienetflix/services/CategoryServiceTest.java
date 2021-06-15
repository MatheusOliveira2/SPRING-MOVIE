package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }

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
