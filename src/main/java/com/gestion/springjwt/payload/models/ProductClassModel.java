package com.gestion.springjwt.payload.models;

public class ProductClassModel {

	private Long id;


	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
   	private Long category;
      
      public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductClassModel() {
		  super();
	}

	
    private String libelle;
      
    
	public String getLibelle() {
		return libelle;
	}

	public ProductClassModel(Long category, String libelle, String slug, String prix, String quantite,
			String description) {
		this.category = category;
		this.libelle = libelle;
		this.slug = slug;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    private String slug;
      
    private String prix;

    private String quantite;

    private String description;

}
