package com.pfe.myschool.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Etudiant",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "matricule"
				+ ""),
		@UniqueConstraint(columnNames = "email")
	})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Etudiant {
	
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
	  private String pere;
	  private String profPere;
	  private String mere;
	  private String profMere;
	  private String tuteur;
	  private String profTuteur;
	  private String codeClasse;
	  private String codeEtalissement;
	  private String etablissement;
	  private String classe;
	  private int annee;
	  private String cinTuteur;
	  private String genre;
	  private String codeNationalite;
	  private String Nationalite;
	  private String tel;
	  private String telTuteur;
	  private String email;
	  private String codeNiveau;
	  private String Bp;
	  private String fileName;
	  private String pwd;
	  private double moy;
	  private String absent;
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
	public String getPere() {
		return pere;
	}
	public void setPere(String pere) {
		this.pere = pere;
	}
	public String getProfPere() {
		return profPere;
	}
	public void setProfPere(String profPere) {
		this.profPere = profPere;
	}
	public String getMere() {
		return mere;
	}
	public void setMere(String mere) {
		this.mere = mere;
	}
	public String getProfMere() {
		return profMere;
	}
	public void setProfMere(String profMere) {
		this.profMere = profMere;
	}
	public String getTuteur() {
		return tuteur;
	}
	public void setTuteur(String tuteur) {
		this.tuteur = tuteur;
	}
	public String getProfTuteur() {
		return profTuteur;
	}
	public void setProfTuteur(String profTuteur) {
		this.profTuteur = profTuteur;
	}
	public String getCodeClasse() {
		return codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	public String getCodeEtalissement() {
		return codeEtalissement;
	}
	public void setCodeEtalissement(String codeEtalissement) {
		this.codeEtalissement = codeEtalissement;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getCinTuteur() {
		return cinTuteur;
	}
	public void setCinTuteur(String cinTuteur) {
		this.cinTuteur = cinTuteur;
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
		return Nationalite;
	}
	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTelTuteur() {
		return telTuteur;
	}
	public void setTelTuteur(String telTuteur) {
		this.telTuteur = telTuteur;
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
	public String getBp() {
		return Bp;
	}
	public void setBp(String bp) {
		Bp = bp;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getMoy() {
		return moy;
	}
	public void setMoy(double moy) {
		this.moy = moy;
	}
	public String getAbsent() {
		return absent;
	}
	public void setAbsent(String absent) {
		this.absent = absent;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", ville=" + ville + ", codePostal=" + codePostal + ", dateNaissance=" + dateNaissance
				+ ", lieu=" + lieu + ", pere=" + pere + ", profPere=" + profPere + ", mere=" + mere + ", profMere="
				+ profMere + ", tuteur=" + tuteur + ", profTuteur=" + profTuteur + ", codeClasse=" + codeClasse
				+ ", codeEtalissement=" + codeEtalissement + ", etablissement=" + etablissement + ", classe=" + classe
				+ ", annee=" + annee + ", cinTuteur=" + cinTuteur + ", genre=" + genre + ", codeNationalite="
				+ codeNationalite + ", Nationalite=" + Nationalite + ", tel=" + tel + ", telTuteur=" + telTuteur
				+ ", email=" + email + ", codeNiveau=" + codeNiveau + ", Bp=" + Bp + ", fileName=" + fileName + ", pwd="
				+ pwd + ", moy=" + moy + ", absent=" + absent + "]";
	}
	public Etudiant(long id, String matricule, String nom, String prenom, String adresse, String ville,
			String codePostal, Date dateNaissance, String lieu, String pere, String profPere, String mere,
			String profMere, String tuteur, String profTuteur, String codeClasse, String codeEtalissement,
			String etablissement, String classe, int annee, String cinTuteur, String genre, String codeNationalite,
			String nationalite, String tel, String telTuteur, String email, String codeNiveau, String bp,
			String fileName, String pwd, double moy, String absent) {
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
		this.pere = pere;
		this.profPere = profPere;
		this.mere = mere;
		this.profMere = profMere;
		this.tuteur = tuteur;
		this.profTuteur = profTuteur;
		this.codeClasse = codeClasse;
		this.codeEtalissement = codeEtalissement;
		this.etablissement = etablissement;
		this.classe = classe;
		this.annee = annee;
		this.cinTuteur = cinTuteur;
		this.genre = genre;
		this.codeNationalite = codeNationalite;
		Nationalite = nationalite;
		this.tel = tel;
		this.telTuteur = telTuteur;
		this.email = email;
		this.codeNiveau = codeNiveau;
		Bp = bp;
		this.fileName = fileName;
		this.pwd = pwd;
		this.moy = moy;
		this.absent = absent;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
