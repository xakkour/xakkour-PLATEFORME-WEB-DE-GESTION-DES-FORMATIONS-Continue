package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "examen")
public class Examen {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int numero;
	  private int annee;
	  private int semestre;
	  private String codeMatiere;
	  private String matiere;
	  private String codeClasse;
    private String classe;
	  private String matriculeEnseignant;
    private String enseignant;
    private String fileName;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Examen [id=" + id + ", numero=" + numero + ", annee=" + annee + ", semestre=" + semestre
				+ ", codeMatiere=" + codeMatiere + ", matiere=" + matiere + ", codeClasse=" + codeClasse + ", classe="
				+ classe + ", matriculeEnseignant=" + matriculeEnseignant + ", enseignant=" + enseignant + ", fileName="
				+ fileName + "]";
	}
	public Examen(long id, int numero, int annee, int semestre, String codeMatiere, String matiere, String codeClasse,
			String classe, String matriculeEnseignant, String enseignant, String fileName) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.semestre = semestre;
		this.codeMatiere = codeMatiere;
		this.matiere = matiere;
		this.codeClasse = codeClasse;
		this.classe = classe;
		this.matriculeEnseignant = matriculeEnseignant;
		this.enseignant = enseignant;
		this.fileName = fileName;
	}
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
