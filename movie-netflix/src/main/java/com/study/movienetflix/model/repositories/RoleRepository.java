package com.study.movienetflix.model.repositories;

import com.study.movienetflix.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
