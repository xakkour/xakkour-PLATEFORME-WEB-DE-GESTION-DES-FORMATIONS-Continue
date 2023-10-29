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
@Table(name = "labsence")
public class Labsence {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int numero;
	  private String matricule;
	  private String nom;
	  private String absent;
	
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Absence absence;

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

	public String getAbsent() {
		return absent;
	}

	public void setAbsent(String absent) {
		this.absent = absent;
	}

	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "Labsence [id=" + id + ", numero=" + numero + ", matricule=" + matricule + ", nom=" + nom + ", absent="
				+ absent + ", absence=" + absence + "]";
	}

	public Labsence(long id, int numero, String matricule, String nom, String absent, Absence absence) {
		super();
		this.id = id;
		this.numero = numero;
		this.matricule = matricule;
		this.nom = nom;
		this.absent = absent;
		this.absence = absence;
	}

	public Labsence() {
		super();
		// TODO Auto-generated constructor stub
	}

}
