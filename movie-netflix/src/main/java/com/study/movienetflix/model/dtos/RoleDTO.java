package com.study.movienetflix.model.dtos;

import javax.validation.constraints.NotBlank;

public class RoleDTO {

    private int id;

    @NotBlank
    private String role;

}
