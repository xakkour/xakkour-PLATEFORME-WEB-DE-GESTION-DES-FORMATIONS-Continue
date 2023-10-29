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
@Table(name = "lnote")
public class Lnote {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int numero;
	  private String matricule;
	  private String nom;
      private double moy;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Note note;
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
	public double getMoy() {
		return moy;
	}
	public void setMoy(double moy) {
		this.moy = moy;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Lnote [id=" + id + ", numero=" + numero + ", matricule=" + matricule + ", nom=" + nom + ", moy=" + moy
				+ ", note=" + note + "]";
	}
	public Lnote(long id, int numero, String matricule, String nom, double moy, Note note) {
		super();
		this.id = id;
		this.numero = numero;
		this.matricule = matricule;
		this.nom = nom;
		this.moy = moy;
		this.note = note;
	}
	public Lnote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
