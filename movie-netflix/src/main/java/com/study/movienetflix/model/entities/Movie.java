package com.study.movienetflix.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@NotBlank
	@Column(nullable = false)
	private String duration;

	@NotBlank
	@Column(nullable = false)
	private String pictureURL;

	public Integer getCategory() {
		return category.getId();
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public Movie() {
		super();
	}

	public Movie(@NotBlank String name, @NotBlank String synopsis, Category category,
			@NotBlank String duration, @NotBlank String pictureURL) {
		super();
		this.name = name;
		this.synopsis = synopsis;
		this.category = category;
		this.duration = duration;
		this.pictureURL = pictureURL;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
