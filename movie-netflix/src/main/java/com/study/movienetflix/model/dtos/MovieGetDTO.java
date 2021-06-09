package com.study.movienetflix.model.dtos;

import com.study.movienetflix.model.entities.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieGetDTO {

    private int id;

    private String name;

    private String synopsis;

    private Category category;

    private String duration;

    private String pictureURL;
}
