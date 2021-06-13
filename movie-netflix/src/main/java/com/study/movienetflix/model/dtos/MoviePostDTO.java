package com.study.movienetflix.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.movienetflix.model.entities.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class MoviePostDTO {

    @NotEmpty(message = "*Please provide a not empty name")
    private String name;

    @NotEmpty(message = "*Please provide a not empty synopsis")
    private String synopsis;

    @NotNull(message = "*Please provide a not null category")
    private Category category;

    @NotEmpty(message = "*Please provide a not empty duration")
    private String duration;

    @NotEmpty(message = "*Please provide a not empty pictureURL")
    private String pictureURL;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
}
