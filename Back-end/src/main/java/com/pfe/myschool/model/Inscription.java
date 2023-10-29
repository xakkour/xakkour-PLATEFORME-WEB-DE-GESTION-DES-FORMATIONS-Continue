package com.pfe.myschool.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Inscription",
uniqueConstraints= {
		@UniqueConstraint(columnNames="numero")
}
		)
public class Inscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int annee;
	private int numero;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private Date dateTnscription;
	private String matricule;
	private String nom;
	private String prenom;
	private String codeClasse;
	private String classe;
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
	public Date getDateTnscription() {
		return dateTnscription;
	}
	public void setDateTnscription(Date dateTnscription) {
		this.dateTnscription = dateTnscription;
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
		return "Inscription [id=" + id + ", annee=" + annee + ", numero=" + numero + ", dateTnscription="
				+ dateTnscription + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", codeClasse="
				+ codeClasse + ", classe=" + classe + ", montant=" + montant + ", dateVersement=" + dateVersement + "]";
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inscription(long id, int annee, int numero, Date dateTnscription, String matricule, String nom,
			String prenom, String codeClasse, String classe, double montant, Date dateVersement) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.dateTnscription = dateTnscription;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.codeClasse = codeClasse;
		this.classe = classe;
		this.montant = montant;
		this.dateVersement = dateVersement;
	}
}
