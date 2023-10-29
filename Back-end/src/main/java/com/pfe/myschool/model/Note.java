package com.pfe.myschool.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "note")
public class Note {

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
      private double coef;
      @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "note", fetch=FetchType.EAGER)
    @Valid
	  private List<Lnote> lnotes = new ArrayList<>();
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
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	public List<Lnote> getLnotes() {
		return lnotes;
	}
	public void setLnotes(List<Lnote> lnotes) {
		this.lnotes = lnotes;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", numero=" + numero + ", annee=" + annee + ", semestre=" + semestre
				+ ", codeMatiere=" + codeMatiere + ", matiere=" + matiere + ", codeClasse=" + codeClasse + ", classe="
				+ classe + ", matriculeEnseignant=" + matriculeEnseignant + ", enseignant=" + enseignant + ", coef="
				+ coef + ", lnotes=" + lnotes + "]";
	}
	public Note(long id, int numero, int annee, int semestre, String codeMatiere, String matiere, String codeClasse,
			String classe, String matriculeEnseignant, String enseignant, double coef, @Valid List<Lnote> lnotes) {
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
		this.coef = coef;
		this.lnotes = lnotes;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
