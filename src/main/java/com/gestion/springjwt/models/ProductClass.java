package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="produits")
public class ProductClass implements Serializable {
	

	private static final long serialVersionUID = 1L;
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id")
	private Long id;


	public CATClass getCategory() {
		return category;
	}

	public void setCategory(CATClass category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
   	private CATClass category;
      
      public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductClass() {
		  super();
	}

	@Column(name="libelle")
    private String libelle;
      
    
	public String getLibelle() {
		return libelle;
	}

	public ProductClass(CATClass category, String libelle, String slug, String prix, String quantite,
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

	@Column(name="slug")
    private String slug;
      
    @Column(name="prix")
    private String prix;

    @Column(name="quantite")
    private String quantite;

    @Column(name="description")
    private String description;

	
      
}
