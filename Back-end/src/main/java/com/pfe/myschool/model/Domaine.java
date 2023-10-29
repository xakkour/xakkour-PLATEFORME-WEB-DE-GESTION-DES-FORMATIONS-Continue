package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Domaine")
public class Domaine {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Domaine [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}
public Domaine(long id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}
}
