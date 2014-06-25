package com.ninja_squad.geektic.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GEEK")
public class Geek {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "MAIL")
	private String mail;

	@Column(name = "COULEURCHEVEUX")
	private String couleurCheveux;

	@Column(name = "COULEURYEUX")
	private String couleurYeux;

	@Column(name = "TAILLE")
	private int taille;

	@Column(name = "SEXE")
	private String sexe;

	@Column(name = "POIDS")
	private int poids;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "GEEK_CENTRE_INTERET", joinColumns = { @JoinColumn(name = "IDGEEK", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "IDCENTREINTERET", referencedColumnName = "ID") })
	public Set<CentreInteret> centresInteret;

	public int getId() {
		return id;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Set<CentreInteret> getCentresInteret() {
		return centresInteret;
	}

	public void setCentresInteret(Set<CentreInteret> centresInteret) {
		this.centresInteret = centresInteret;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCouleurCheveux() {
		return couleurCheveux;
	}

	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

}
