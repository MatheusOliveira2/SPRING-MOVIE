package com.study.movienetflix.model.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RolePostDTO {

    private int id;

    @NotBlank
    @NotNull
    private String role;

}
