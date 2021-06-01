package com.study.movienetflix.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
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


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@NotBlank
	@Column(nullable = false)
	private String duration;

	@NotBlank
	@Column(nullable = false)
	private String pictureURL;

	@NotNull
	private LocalDateTime createdAt;

	@NotNull
	private LocalDateTime editedAt;

	@NotNull
	private boolean published;

}
