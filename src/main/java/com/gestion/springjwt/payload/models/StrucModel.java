package com.gestion.springjwt.payload.models;



public class StrucModel {

   
	private Long id;
    

  private String nom;
    

  private String addresse;
    

  public StrucModel() {
	super();
	// TODO Auto-generated constructor stub
}


public StrucModel(Long id, String nom, String addresse, String numTel, String description) {
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


private String numTel;
    

  private String description;
}
