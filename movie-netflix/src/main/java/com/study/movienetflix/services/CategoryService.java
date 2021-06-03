package com.study.movienetflix.services;

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
    public CategoryPostDTO save(CategoryPostDTO dto){
        Category entity = mapper.map(dto, Category.class);
        repository.save(entity);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<CategoryPostDTO> findAll(){
        List<Category> list = repository.findAll();
        return list.stream().map(movie -> mapper.map(movie, CategoryPostDTO.class)).collect(Collectors.toList());
    }
}
