package com.study.movienetflix.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String name;

	@NotBlank
	@Column(nullable = false)
	private String synopsis;

	@OneToOne
	@NotBlank
	private Category category;

	@NotBlank
	@Column(nullable = false)
	private String duration;

	public Movie() {
		super();
	}

	public Movie(@NotBlank String name, @NotBlank String synopsis, @NotBlank Category category,
			@NotBlank String duration) {
		super();
		this.name = name;
		this.synopsis = synopsis;
		this.category = category;
		this.duration = duration;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Category getCategorie() {
		return category;
	}

	public void setCategorie(Category category) {
		this.category = category;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
