package com.pfe.myschool.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Lreglement")
public class Lreglement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int annee;
	private int numero;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private Date echeance;
	private String ModReglement;
	private double Montant;
	private String numpiece;
	private String Banque;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	private Reglement reglement;
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
	public Date getEcheance() {
		return echeance;
	}
	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}
	public String getModReglement() {
		return ModReglement;
	}
	public void setModReglement(String modReglement) {
		ModReglement = modReglement;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public String getNumpiece() {
		return numpiece;
	}
	public void setNumpiece(String numpiece) {
		this.numpiece = numpiece;
	}
	public String getBanque() {
		return Banque;
	}
	public void setBanque(String banque) {
		Banque = banque;
	}
	public Reglement getReglement() {
		return reglement;
	}
	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}
	@Override
	public String toString() {
		return "Lreglement [id=" + id + ", annee=" + annee + ", numero=" + numero + ", echeance=" + echeance
				+ ", ModReglement=" + ModReglement + ", Montant=" + Montant + ", numpiece=" + numpiece + ", Banque="
				+ Banque + ", reglement=" + reglement + "]";
	}
	public Lreglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lreglement(long id, int annee, int numero, Date echeance, String modReglement, double montant,
			String numpiece, String banque, Reglement reglement) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.echeance = echeance;
		ModReglement = modReglement;
		Montant = montant;
		this.numpiece = numpiece;
		Banque = banque;
		this.reglement = reglement;
	}
	
}
