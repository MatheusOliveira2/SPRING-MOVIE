package com.study.movienetflix.controllers;


import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.services.RoleService;
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
    public RolePostDTO newRole(@RequestBody @Valid RolePostDTO role, Errors errors) {
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        service.save(role);
        return role;
    }

    @GetMapping
    public List<RoleGetDTO> getRoles(){
        return service.findAll();
    }
}
