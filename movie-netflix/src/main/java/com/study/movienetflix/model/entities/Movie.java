package com.study.movienetflix.model.entities;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@NotBlank
	@Column(nullable = false)
	private String categorie;

	@NotBlank
	@Column(nullable = false)
	private Time duration;

	public Movie() {
		super();
	}

	public Movie(@NotBlank String name, @NotBlank String synopsis, @NotBlank String categorie,
			@NotBlank Time duration) {
		super();
		this.name = name;
		this.synopsis = synopsis;
		this.categorie = categorie;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}
}
