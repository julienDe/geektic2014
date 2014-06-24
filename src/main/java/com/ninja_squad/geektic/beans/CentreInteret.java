package com.ninja_squad.geektic.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CENTRE_INTERET")
public class CentreInteret {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM")
	private String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
