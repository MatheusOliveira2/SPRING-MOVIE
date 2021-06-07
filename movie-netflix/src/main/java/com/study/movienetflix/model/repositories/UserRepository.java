package com.study.movienetflix.model.repositories;

import com.study.movienetflix.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
}
