package com.gestion.springjwt.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="structure_appui")
public class CommandClass implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
    
    public CommandClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandClass(Long id, String nom, String addresse, String numTel, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.addresse = addresse;
		this.numTel = numTel;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name="nom")
  private String nom;
    
    @Column(name="addresse")
  private String addresse;
    
    @Column(name="num_tel")
  private String numTel;
    
    @Column(name="description")
  private String description;
}
