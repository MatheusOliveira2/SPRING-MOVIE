package com.study.movienetflix.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.movienetflix.model.entities.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class MoviePostDTO {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String synopsis;

    @NotNull
    private Integer category;

    @NotBlank
    @NotNull
    private String duration;

    @NotBlank
    @NotNull
    private String pictureURL;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
}
