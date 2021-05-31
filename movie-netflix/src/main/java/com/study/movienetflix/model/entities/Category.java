package com.study.movienetflix.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "category")
	private Movie movie;

	public Category(@NotBlank String name, Movie movie) {
		super();
		this.name = name;
		this.movie = movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
