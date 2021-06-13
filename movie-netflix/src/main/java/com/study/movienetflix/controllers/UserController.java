package com.study.movienetflix.controllers;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.UserGetDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.services.UserService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserPostDTO newUser(@RequestBody @Valid UserPostDTO role, Errors errors) {
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        service.save(role);
        return role;
    }

    @GetMapping
    public List<UserGetDTO> getUsers(){
        return service.findAll();
    }
}
