package com.pfe.myschool.model;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "enseignant",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "matricule"
				+ ""),
		@UniqueConstraint(columnNames = "email")
	})
public class Enseignant {
	
	
	
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(long id, String matricule, String nom, String prenom, String adresse, String ville,
			String codePostal, Date dateNaissance, String lieu, String codeEtablissement, String etablissement,
			int annee, String cin, String genre, String codeNationalite, String nationalite, String tel, String email,
			String codeNiveau, String niveau, String fileName) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.lieu = lieu;
		this.codeEtablissement = codeEtablissement;
		this.etablissement = etablissement;
		this.annee = annee;
		this.cin = cin;
		this.genre = genre;
		this.codeNationalite = codeNationalite;
		this.nationalite = nationalite;
		this.tel = tel;
		this.email = email;
		this.codeNiveau = codeNiveau;
		this.niveau = niveau;
		this.fileName = fileName;
	}
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String matricule;
	  private String nom;
	  private String prenom;
	  private String adresse;
	  private String ville;
	  private String codePostal;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateNaissance;
	  private String lieu;
	  private String codeEtablissement;
	  private String etablissement;
	  private int annee;
	  private String cin;
	  private String genre;
	  private String codeNationalite;
	  private String nationalite;
	  private String tel;
	  private String email;
	  private String codeNiveau;
	  private String niveau;
	  private String fileName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getCodeEtablissement() {
		return codeEtablissement;
	}
	public void setCodeEtablissement(String codeEtablissement) {
		this.codeEtablissement = codeEtablissement;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCodeNationalite() {
		return codeNationalite;
	}
	public void setCodeNationalite(String codeNationalite) {
		this.codeNationalite = codeNationalite;
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
	public String getCodeNiveau() {
		return codeNiveau;
	}
	public void setCodeNiveau(String codeNiveau) {
		this.codeNiveau = codeNiveau;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", ville=" + ville + ", codePostal=" + codePostal + ", dateNaissance="
				+ dateNaissance + ", lieu=" + lieu + ", codeEtablissement=" + codeEtablissement + ", etablissement="
				+ etablissement + ", annee=" + annee + ", cin=" + cin + ", genre=" + genre + ", codeNationalite="
				+ codeNationalite + ", nationalite=" + nationalite + ", tel=" + tel + ", email=" + email
				+ ", codeNiveau=" + codeNiveau + ", niveau=" + niveau + ", fileName=" + fileName + "]";
	}
	
	
}
