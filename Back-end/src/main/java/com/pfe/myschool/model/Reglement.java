package com.pfe.myschool.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Reglement",
uniqueConstraints = {
		@UniqueConstraint(columnNames ="numero")
}
		)
public class Reglement {
	
	
	
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateReglement;
	  private String matricule;
	  private String nom;
	  private String prenom;
	  private double montant;
	  private double espece;
	  private double cheque;
	  private String classe;
	  private int numInscription;;
	  private String ModReglement;
	  @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "reglement", fetch=FetchType.EAGER)
  @Valid
	  private List<Lreglement> lreglements = new ArrayList<>();
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDateReglement() {
		return dateReglement;
	}
	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getEspece() {
		return espece;
	}
	public void setEspece(double espece) {
		this.espece = espece;
	}
	public double getCheque() {
		return cheque;
	}
	public void setCheque(double cheque) {
		this.cheque = cheque;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getNumInscription() {
		return numInscription;
	}
	public void setNumInscription(int numInscription) {
		this.numInscription = numInscription;
	}
	public String getModReglement() {
		return ModReglement;
	}
	public void setModReglement(String modReglement) {
		ModReglement = modReglement;
	}
	@Override
	public String toString() {
		return "Reglement [id=" + id + ", annee=" + annee + ", numero=" + numero + ", dateReglement=" + dateReglement
				+ ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", montant=" + montant
				+ ", espece=" + espece + ", cheque=" + cheque + ", classe=" + classe + ", numInscription="
				+ numInscription + ", ModReglement=" + ModReglement + "]";
	}
	
	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reglement(long id, int annee, int numero, Date dateReglement, String matricule, String nom, String prenom,
			double montant, double espece, double cheque, String classe, int numInscription, String modReglement) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.dateReglement = dateReglement;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
		this.espece = espece;
		this.cheque = cheque;
		this.classe = classe;
		this.numInscription = numInscription;
		ModReglement = modReglement;
	}
	public List<Lreglement> getLreglement() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
