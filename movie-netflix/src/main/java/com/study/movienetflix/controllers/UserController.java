package com.study.movienetflix.controllers;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.UserGetDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.services.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserGetDTO> newUser(@RequestBody @Valid UserPostDTO role, Errors errors) {
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }

        return ResponseEntity.ok(service.save(role));
    }

    @GetMapping
    public ResponseEntity<List<UserGetDTO>> getUsers(){
        return ResponseEntity.ok(service.findAll());
    }
}
