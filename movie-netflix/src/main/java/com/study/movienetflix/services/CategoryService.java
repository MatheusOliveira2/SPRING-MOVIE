package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.CategoryGetDTO;
import com.study.movienetflix.model.dtos.CategoryPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.repositories.CategoryRepository;
import com.study.movienetflix.util.MessageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private  CategoryRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CategoryGetDTO save(CategoryPostDTO dto){
        Optional<Category> optionalCategory = repository.findByName(dto.getName());
        if(optionalCategory.isPresent()){
            throw new BusinessException(MessageUtils.CATEGORY_ALREADY_EXISTS);
        }

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
