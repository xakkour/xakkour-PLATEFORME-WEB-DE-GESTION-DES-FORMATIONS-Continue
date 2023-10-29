package com.pfe.myschool.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "qcm")
public class Qcm {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int numero;
	private int annee;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private String codeClasse;
	private String codeMatiere;
	private String  matriculeEnseignant;
	private String matiere;
	private String classe;
	private String enseignant;
	@JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "qcm", fetch=FetchType.EAGER)
  @Valid
	  private List<Lqcm> lqcms = new ArrayList<>();
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
	public String getMatriculeEnseignant() {
		return matriculeEnseignant;
	}
	public void setMatriculeEnseignant(String matriculeEnseignant) {
		this.matriculeEnseignant = matriculeEnseignant;
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
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public List<Lqcm> getLqcms() {
		return lqcms;
	}
	public void setLqcms(List<Lqcm> lqcms) {
		this.lqcms = lqcms;
	}
	@Override
	public String toString() {
		return "Qcm [id=" + id + ", numero=" + numero + ", annee=" + annee + ", codeClasse=" + codeClasse
				+ ", codeMatiere=" + codeMatiere + ", matriculeEnseignant=" + matriculeEnseignant + ", matiere="
				+ matiere + ", classe=" + classe + ", enseignant=" + enseignant + ", lqcms=" + lqcms + "]";
	}
	public Qcm(long id, int numero, int annee, String codeClasse, String codeMatiere, String matriculeEnseignant,
			String matiere, String classe, String enseignant, @Valid List<Lqcm> lqcms) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.codeClasse = codeClasse;
		this.codeMatiere = codeMatiere;
		this.matriculeEnseignant = matriculeEnseignant;
		this.matiere = matiere;
		this.classe = classe;
		this.enseignant = enseignant;
		this.lqcms = lqcms;
	}
	public Qcm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
