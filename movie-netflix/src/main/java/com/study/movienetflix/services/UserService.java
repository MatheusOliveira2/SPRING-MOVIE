package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.model.entities.Role;
import com.study.movienetflix.model.entities.User;
import com.study.movienetflix.model.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Transactional
    public UserPostDTO save(UserPostDTO dto) {
        User entity = mapper.map(dto, User.class);
        repository.save(entity);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<UserPostDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(user -> mapper.map(user, UserPostDTO.class)).collect(Collectors.toList());
    }

}
