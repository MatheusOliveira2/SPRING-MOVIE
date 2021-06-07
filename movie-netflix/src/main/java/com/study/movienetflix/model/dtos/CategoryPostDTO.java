package com.study.movienetflix.model.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryPostDTO {

    private int id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

}
