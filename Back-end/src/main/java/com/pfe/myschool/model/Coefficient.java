package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Coefficient",
uniqueConstraints = {
	@UniqueConstraint(columnNames = "code")
})
public class Coefficient {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private long id;
	private String code;
	private String codeClasse;
	private String classe;
	private String codeMatiere;
	private String matiere;
	private double coef;
	private String libelle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Coefficient [id=" + id + ", code=" + code + ", codeClasse=" + codeClasse + ", classe=" + classe
				+ ", codeMatiere=" + codeMatiere + ", matiere=" + matiere + ", coef=" + coef + ", libelle=" + libelle
				+ "]";
	}
	public Coefficient(long id, String code, String codeClasse, String classe, String codeMatiere, String matiere,
			double coef, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.codeClasse = codeClasse;
		this.classe = classe;
		this.codeMatiere = codeMatiere;
		this.matiere = matiere;
		this.coef = coef;
		this.libelle = libelle;
	}
	public Coefficient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
