package com.study.movienetflix.controllers;

import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public UserPostDTO newUser(@RequestBody @Valid UserPostDTO role) {
        service.save(role);
        return role;
    }

    @GetMapping
    public List<UserPostDTO> getUsers(){
        return service.findAll();
    }
}
