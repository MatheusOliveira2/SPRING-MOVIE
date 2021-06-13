package com.study.movienetflix.controllers;


import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/role")
public class RoleController {

    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoleGetDTO> newRole(@RequestBody @Valid RolePostDTO role, Errors errors) {
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(service.save(role));
    }

    @GetMapping
    public ResponseEntity<List<RoleGetDTO>> getRoles(){
        return ResponseEntity.ok(service.findAll());
    }
}
