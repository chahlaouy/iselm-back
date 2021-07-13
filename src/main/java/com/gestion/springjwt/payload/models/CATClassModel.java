package com.gestion.springjwt.payload.models;

import java.util.Date;

public class CATClassModel {
   
	private Long id;
	
	private String nom;
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CATClassModel [description=" + description + ", id=" + id + ", nom=" + nom + ", slug=" + slug + "]";
	}

	public CATClassModel(Long id, String nom, String slug, String description) {
		this.id = id;
		this.nom = nom;
		this.slug = slug;
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CATClassModel() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String slug;

	private String description;


	


	
	
}
