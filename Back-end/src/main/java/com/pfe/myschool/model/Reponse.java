package com.pfe.myschool.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reponse")
public class Reponse {
	
	
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reponse(long id, int numero, int annee, String matricule, String reponse) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.matricule = matricule;
		this.reponse = reponse;
	}

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int numero;
	private int annee;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private String matricule;
	private String reponse;
	
	public List<Lqcm> getLqcm() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", numero=" + numero + ", annee=" + annee + ", matricule=" + matricule
				+ ", reponse=" + reponse + "]";
	}

}
