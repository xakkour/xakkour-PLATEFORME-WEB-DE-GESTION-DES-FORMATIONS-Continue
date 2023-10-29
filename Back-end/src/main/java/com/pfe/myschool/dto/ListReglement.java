package com.pfe.myschool.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListReglement {
	
	
	private long id;
	 private int annee;
	 private int numero;
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	 private Date dateReglement;
	 private String matricule;
	 private double montant;
	 private String nom;
	 private String prenom;
	 private String classe;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDateReglement() {
		return dateReglement;
	}
	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public ListReglement(long id, int annee, int numero, Date dateReglement, String matricule, double montant,
			String nom, String prenom, String classe) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.dateReglement = dateReglement;
		this.matricule = matricule;
		this.montant = montant;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
	}
}
