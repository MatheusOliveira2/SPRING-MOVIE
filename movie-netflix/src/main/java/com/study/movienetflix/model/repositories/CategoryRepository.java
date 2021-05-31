package com.study.movienetflix.model.repositories;


import com.study.movienetflix.model.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
