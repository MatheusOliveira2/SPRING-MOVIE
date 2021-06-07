package com.study.movienetflix.model.dtos;

import com.study.movienetflix.model.entities.Role;
import lombok.Getter;

import java.util.Set;

@Getter
public class UserGetDTO {

    private int id;

    private String userName;

    private String email;

    private String password;

    private String name;

    private String lastName;

    private Boolean active;

    private Set<Role> roles;
}
