package com.pfe.myschool.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListInscription {

	
	
	private long id;
	 private int annee;
	 private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateInscription;
	  private String matricule;
	  private String nom;
	  private String prenom;
	  private String codeClasse;
	  private String classe;
	  private String codeSpecialite;
	  private String specialite;
	  private double montant;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateVersement;
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
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public String getCodeClasse() {
		return codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getCodeSpecialite() {
		return codeSpecialite;
	}
	public void setCodeSpecialite(String codeSpecialite) {
		this.codeSpecialite = codeSpecialite;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateVersement() {
		return dateVersement;
	}
	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}
	@Override
	public String toString() {
		return "ListInscription [id=" + id + ", annee=" + annee + ", numero=" + numero + ", dateInscription="
				+ dateInscription + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", codeClasse="
				+ codeClasse + ", classe=" + classe + ", codeSpecialite=" + codeSpecialite + ", specialite="
				+ specialite + ", montant=" + montant + ", dateVersement=" + dateVersement + "]";
	}
	
	public ListInscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListInscription(long id, int annee, int numero, Date dateInscription, String matricule, String nom,
			String prenom, String codeClasse, String classe, String codeSpecialite, String specialite, double montant,
			Date dateVersement) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.dateInscription = dateInscription;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.codeClasse = codeClasse;
		this.classe = classe;
		this.codeSpecialite = codeSpecialite;
		this.specialite = specialite;
		this.montant = montant;
		this.dateVersement = dateVersement;
	}
}
