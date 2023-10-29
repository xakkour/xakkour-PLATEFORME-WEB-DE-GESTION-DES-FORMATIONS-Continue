package com.pfe.myschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "lemploi")
public class Lemploi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int numero;
	private int annee;
	private String jour;
	private String horaire;
	private String codeMatiere;
	private String matiere;
	private String matriculeEnseignant;
	private String enseignant;
	private String codeJour;
	private String codeHoraire;
	private String Salle;
	 @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Emploi emploi;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getCodeMatiere() {
		return codeMatiere;
	}
	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getMatriculeEnseignant() {
		return matriculeEnseignant;
	}
	public void setMatriculeEnseignant(String matriculeEnseignant) {
		this.matriculeEnseignant = matriculeEnseignant;
	}
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public String getCodeJour() {
		return codeJour;
	}
	public void setCodeJour(String codeJour) {
		this.codeJour = codeJour;
	}
	public String getCodeHoraire() {
		return codeHoraire;
	}
	public void setCodeHoraire(String codeHoraire) {
		this.codeHoraire = codeHoraire;
	}
	public String getSalle() {
		return Salle;
	}
	public void setSalle(String salle) {
		Salle = salle;
	}
	public Emploi getEmploi() {
		return emploi;
	}
	public void setEmploi(Emploi emploi) {
		this.emploi = emploi;
	}
	@Override
	public String toString() {
		return "Lemploi [id=" + id + ", numero=" + numero + ", annee=" + annee + ", jour=" + jour + ", horaire="
				+ horaire + ", codeMatiere=" + codeMatiere + ", matiere=" + matiere + ", matriculeEnseignant="
				+ matriculeEnseignant + ", enseignant=" + enseignant + ", codeJour=" + codeJour + ", codeHoraire="
				+ codeHoraire + ", Salle=" + Salle + ", emploi=" + emploi + "]";
	}
	public Lemploi(long id, int numero, int annee, String jour, String horaire, String codeMatiere, String matiere,
			String matriculeEnseignant, String enseignant, String codeJour, String codeHoraire, String salle,
			Emploi emploi) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.jour = jour;
		this.horaire = horaire;
		this.codeMatiere = codeMatiere;
		this.matiere = matiere;
		this.matriculeEnseignant = matriculeEnseignant;
		this.enseignant = enseignant;
		this.codeJour = codeJour;
		this.codeHoraire = codeHoraire;
		Salle = salle;
		this.emploi = emploi;
	}
	public Lemploi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
