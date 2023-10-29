package com.pfe.myschool.dto;

public class ListCours {
	public ListCours(long id, int numero, int annee, String matriculeEnseignant, String codeClasse, String codeMatiere,
			String enseignant, String classe, String matiere, int semestre) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.matriculeEnseignant = matriculeEnseignant;
		this.codeClasse = codeClasse;
		this.codeMatiere = codeMatiere;
		this.enseignant = enseignant;
		this.classe = classe;
		this.matiere = matiere;
		this.semestre = semestre;
	}
	public ListCours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	  private int numero;
	  private int annee;
	  private String matriculeEnseignant;
	  private String codeClasse;
	  private String codeMatiere;
	  private String enseignant;
	  private String classe;
	  private String matiere;
	  private int semestre;
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
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
	
}
