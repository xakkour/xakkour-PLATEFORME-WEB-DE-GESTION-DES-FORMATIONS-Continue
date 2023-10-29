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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "emploi")
public class Emploi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	private int numero;
	private int annee;
	private int semestre;
	private String codeClasse;
	private String Classe;
	 @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "emploi", fetch=FetchType.EAGER)
   @Valid
	  private List<Lemploi> lemplois = new ArrayList<>();
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
	public String getCodeClasse() {
		return codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}
	public List<Lemploi> getLemplois() {
		return lemplois;
	}
	public void setLemplois(List<Lemploi> lemplois) {
		this.lemplois = lemplois;
	}
	@Override
	public String toString() {
		return "Emploi [id=" + id + ", numero=" + numero + ", annee=" + annee + ", semestre=" + semestre
				+ ", codeClasse=" + codeClasse + ", Classe=" + Classe + ", lemplois=" + lemplois + "]";
	}
	public Emploi(long id, int numero, int annee, int semestre, String codeClasse, String classe,
			@Valid List<Lemploi> lemplois) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.semestre = semestre;
		this.codeClasse = codeClasse;
		Classe = classe;
		this.lemplois = lemplois;
	}
	public Emploi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
