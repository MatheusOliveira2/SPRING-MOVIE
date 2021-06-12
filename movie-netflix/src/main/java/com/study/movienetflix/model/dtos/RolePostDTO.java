package com.study.movienetflix.model.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RolePostDTO {
    @NotNull
    @NotEmpty(message = "*Please provide a not empty role")
    private String role;

}
