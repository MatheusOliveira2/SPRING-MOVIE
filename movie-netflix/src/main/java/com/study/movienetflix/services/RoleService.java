package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.entities.Role;
import com.study.movienetflix.model.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Transactional
    public RolePostDTO save(RolePostDTO dto) {
        Role entity = mapper.map(dto, Role.class);
        repository.save(entity);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<RolePostDTO> findAll() {
        List<Role> list = repository.findAll();
        return list.stream().map(role -> mapper.map(role, RolePostDTO.class)).collect(Collectors.toList());
    }
}
