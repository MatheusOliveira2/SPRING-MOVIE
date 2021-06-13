package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.UserGetDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.model.entities.User;
import com.study.movienetflix.model.repositories.UserRepository;
import com.study.movienetflix.util.MessageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserGetDTO save(UserPostDTO dto) {
        Optional<User> optionalUser = repository.findByUserName(dto.getUserName());
        if(optionalUser.isPresent()){
            throw new BusinessException(MessageUtils.USER_ALREADY_EXISTS);
        }
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
