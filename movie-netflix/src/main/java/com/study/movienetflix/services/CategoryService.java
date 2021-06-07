package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public CategoryGetDTO save(CategoryPostDTO dto){
        Category entity = mapper.map(dto, Category.class);
        Category category = repository.save(entity);
        return mapper.map(category, CategoryGetDTO.class);
    }

    @Transactional(readOnly = true)
    public List<CategoryGetDTO> findAll(){
        List<Category> list = repository.findAll();
        return list.stream().map(movie -> mapper.map(movie, CategoryGetDTO.class)).collect(Collectors.toList());
    }
}
