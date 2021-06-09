package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.RoleGetDTO;
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

    private RoleRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public RoleGetDTO save(RolePostDTO dto) {
        Role entity = mapper.map(dto, Role.class);
        Role role = repository.save(entity);
        mapper.map(role, Role.class);
        return mapper.map(role, RoleGetDTO.class);
    }

    @Transactional(readOnly = true)
    public List<RoleGetDTO> findAll() {
        List<Role> list = repository.findAll();
        return list.stream().map(role -> mapper.map(role, RoleGetDTO.class)).collect(Collectors.toList());
    }
}
