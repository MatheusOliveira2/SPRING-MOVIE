package com.study.movienetflix.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = false, nullable = false)
	@NotBlank
	private String name;
	
	@Column(unique = true, nullable = false)
	@NotBlank
	private String email;
	
	@NotBlank
	@Column(unique = false, nullable = false)
	private String password;
	
	public User() {
		super();
	}
	
	public User(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
