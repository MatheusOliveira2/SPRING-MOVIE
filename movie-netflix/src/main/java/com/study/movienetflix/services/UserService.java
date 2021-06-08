package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.dtos.UserGetDTO;
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
    public UserGetDTO save(UserPostDTO dto) {
        User entity = mapper.map(dto, User.class);
        User user = repository.save(entity);
        return mapper.map(user, UserGetDTO.class);
    }

    @Transactional(readOnly = true)
    public List<UserGetDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(user -> mapper.map(user, UserGetDTO.class)).collect(Collectors.toList());
    }

}
