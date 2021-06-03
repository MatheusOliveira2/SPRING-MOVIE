package com.study.movienetflix.model.repositories;


import com.study.movienetflix.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
