package com.pfe.myschool.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListEtudiant {
	
	private long id;
	  private String mat;
	  private String nom;
	  private String prenom;
	  private String classe;
	  private String genre;
	  private String nationalite;
	  private String tel;
	  private String email;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dea;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDea() {
		return dea;
	}
	public void setDea(Date dea) {
		this.dea = dea;
	}
	@Override
	public String toString() {
		return "ListEtudiant [id=" + id + ", mat=" + mat + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe
				+ ", genre=" + genre + ", nationalite=" + nationalite + ", tel=" + tel + ", email=" + email + ", dea="
				+ dea + "]";
	}

	public ListEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListEtudiant(long id, String mat, String nom, String prenom, String classe, String genre, String nationalite,
			String tel, String email, Date dea) {
		super();
		this.id = id;
		this.mat = mat;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.genre = genre;
		this.nationalite = nationalite;
		this.tel = tel;
		this.email = email;
		this.dea = dea;
	}
}
