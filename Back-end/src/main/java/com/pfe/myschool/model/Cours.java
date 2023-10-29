package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cours",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "numero")
	})
public class Cours {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	  private int numero;
	  private int annee;
	  private int semestre;
	  private String matriculeEnseignant;
	  private String codeClasse;
	  private String codeMatiere;
	  private String matiere;
	  private String classe;
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
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public String getMatriculeEnseignant() {
		return matriculeEnseignant;
	}
	public void setMatriculeEnseignant(String matriculeEnseignant) {
		this.matriculeEnseignant = matriculeEnseignant;
	}
	public String getCodeClasse() {
		return codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@Override
	public String toString() {
		return "Cours [id=" + id + ", numero=" + numero + ", annee=" + annee + ", semestre=" + semestre
				+ ", matriculeEnseignant=" + matriculeEnseignant + ", codeClasse=" + codeClasse + ", codeMatiere="
				+ codeMatiere + ", matiere=" + matiere + ", classe=" + classe + "]";
	}
	public Cours(long id, int numero, int annee, int semestre, String matriculeEnseignant, String codeClasse,
			String codeMatiere, String matiere, String classe) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.semestre = semestre;
		this.matriculeEnseignant = matriculeEnseignant;
		this.codeClasse = codeClasse;
		this.codeMatiere = codeMatiere;
		this.matiere = matiere;
		this.classe = classe;
	}
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	
	
}
