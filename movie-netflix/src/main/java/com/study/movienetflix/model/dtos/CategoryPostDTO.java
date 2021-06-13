package com.study.movienetflix.model.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@EqualsAndHashCode
public class CategoryPostDTO {

    @NotEmpty(message = "*Please provide a not empty name")
    private String name;

}
