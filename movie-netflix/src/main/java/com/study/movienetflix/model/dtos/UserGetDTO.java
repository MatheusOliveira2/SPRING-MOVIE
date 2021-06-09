package com.study.movienetflix.model.dtos;

import com.study.movienetflix.model.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserGetDTO {

    private int id;

    private String userName;

    private String email;

    private String name;

    private String lastName;

    private Boolean active;

    private Set<Role> roles;
}
