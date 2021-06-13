package com.study.movienetflix.model.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
public class RolePostDTO {


    @NotEmpty(message = "*Please provide a not empty role")
    private String role;

}
