package com.study.movienetflix.model.repositories;


import org.springframework.data.repository.CrudRepository;

import com.study.movienetflix.model.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
