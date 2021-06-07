package com.study.movienetflix.controllers;


import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/role")
public class RoleController {

    @Autowired
    RoleService service;

    @PostMapping
    public RolePostDTO newRole(@RequestBody @Valid RolePostDTO role) {
        service.save(role);
        return role;
    }

    @GetMapping
    public List<RolePostDTO> getRoles(){
        return service.findAll();
    }
}
