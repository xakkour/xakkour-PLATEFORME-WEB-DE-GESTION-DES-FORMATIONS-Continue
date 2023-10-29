package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "Compteur",
uniqueConstraints = {
		@UniqueConstraint(columnNames="annee")
}
		)
public class Compteur {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private int annee;
	private int numReglement;
	private int numInscription;
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
	public int getNumReglement() {
		return numReglement;
	}
	public void setNumReglement(int numReglement) {
		this.numReglement = numReglement;
	}
	public int getNumInscription() {
		return numInscription;
	}
	public void setNumInscription(int numInscription) {
		this.numInscription = numInscription;
	}
	@Override
	public String toString() {
		return "Compteur [id=" + id + ", annee=" + annee + ", numReglement=" + numReglement + ", numInscription="
				+ numInscription + "]";
	}

	public Compteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compteur(long id, int annee, int numReglement, int numInscription) {
		super();
		this.id = id;
		this.annee = annee;
		this.numReglement = numReglement;
		this.numInscription = numInscription;
	}
}
