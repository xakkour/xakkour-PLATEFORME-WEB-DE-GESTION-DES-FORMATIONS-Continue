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
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "absence")
public class Absence {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int numero;
	  private int annee;
	  private int semestre;
	  private String codeMatiere;
	  private String matiere;
	  private String codeClasse;
      private String classe;
	  private String matriculeEnseignant;
      private String enseignant;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateJour;
	  private String codeHoraire;
      private String horaire;
     
      @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "absence", fetch=FetchType.EAGER)
    @Valid
	  private List<Labsence> labsences = new ArrayList<>();

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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getCodeMatiere() {
		return codeMatiere;
	}

	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMatriculeEnseignant() {
		return matriculeEnseignant;
	}

	public void setMatriculeEnseignant(String matriculeEnseignant) {
		this.matriculeEnseignant = matriculeEnseignant;
	}

	public String getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public String getCodeHoraire() {
		return codeHoraire;
	}

	public void setCodeHoraire(String codeHoraire) {
		this.codeHoraire = codeHoraire;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public List<Labsence> getLabsences() {
		return labsences;
	}

	public void setLabsences(List<Labsence> labsences) {
		this.labsences = labsences;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", numero=" + numero + ", annee=" + annee + ", semestre=" + semestre
				+ ", codeMatiere=" + codeMatiere + ", matiere=" + matiere + ", codeClasse=" + codeClasse + ", classe="
				+ classe + ", matriculeEnseignant=" + matriculeEnseignant + ", enseignant=" + enseignant + ", dateJour="
				+ dateJour + ", codeHoraire=" + codeHoraire + ", horaire=" + horaire + ", labsences=" + labsences + "]";
	}

	public Absence(long id, int numero, int annee, int semestre, String codeMatiere, String matiere, String codeClasse,
			String classe, String matriculeEnseignant, String enseignant, Date dateJour, String codeHoraire,
			String horaire, @Valid List<Labsence> labsences) {
		super();
		this.id = id;
		this.numero = numero;
		this.annee = annee;
		this.semestre = semestre;
		this.codeMatiere = codeMatiere;
		this.matiere = matiere;
		this.codeClasse = codeClasse;
		this.classe = classe;
		this.matriculeEnseignant = matriculeEnseignant;
		this.enseignant = enseignant;
		this.dateJour = dateJour;
		this.codeHoraire = codeHoraire;
		this.horaire = horaire;
		this.labsences = labsences;
	}

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
