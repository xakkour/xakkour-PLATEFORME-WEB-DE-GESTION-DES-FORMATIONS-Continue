package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Institut",
uniqueConstraints= {
		@UniqueConstraint(columnNames="libelle")
}
		)
public class Institut {
	
	
	
	public Institut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Institut(long id, String code, String libelle, String libelleCourt, String adresse, String tel1, String tel2,
			String email, String slogant) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.libelleCourt = libelleCourt;
		this.adresse = adresse;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email = email;
		this.slogant = slogant;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String libelle;
	private String libelleCourt;
	private String adresse;
	private String tel1;
	private String tel2;
	private String email;
	private String slogant;
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
	public String getLibelleCourt() {
		return libelleCourt;
	}
	public void setLibelleCourt(String libelleCourt) {
		this.libelleCourt = libelleCourt;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSlogant() {
		return slogant;
	}
	public void setSlogant(String slogant) {
		this.slogant = slogant;
	}
	@Override
	public String toString() {
		return "Institut [id=" + id + ", code=" + code + ", libelle=" + libelle + ", libelleCourt=" + libelleCourt
				+ ", adresse=" + adresse + ", tel1=" + tel1 + ", tel2=" + tel2 + ", email=" + email + ", slogant="
				+ slogant + "]";
	}

	
}
