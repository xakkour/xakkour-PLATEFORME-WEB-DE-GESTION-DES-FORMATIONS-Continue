package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "Etablissement",
uniqueConstraints = {
		@UniqueConstraint(columnNames="code" + ""),
		@UniqueConstraint(columnNames="libelle")
}
	)
public class Etablissement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String libelle;
	private String adresse;
	private String ville;
	private String tel;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Etablissement [id=" + id + ", code=" + code + ", libelle=" + libelle + ", adresse=" + adresse
				+ ", ville=" + ville + ", tel=" + tel + "]";
	}
	public Etablissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etablissement(long id, String code, String libelle, String adresse, String ville, String tel) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.adresse = adresse;
		this.ville = ville;
		this.tel = tel;
	}
}
