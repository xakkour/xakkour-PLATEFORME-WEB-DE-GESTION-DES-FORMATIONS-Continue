package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String code;
	  private String libelle;
	  private String codeSpecialite;
	  private String codeDomaine;
	  private String codeCycle;
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
	public String getCodeSpecialite() {
		return codeSpecialite;
	}
	public void setCodeSpecialite(String codeSpecialite) {
		this.codeSpecialite = codeSpecialite;
	}
	public String getCodeDomaine() {
		return codeDomaine;
	}
	public void setCodeDomaine(String codeDomaine) {
		this.codeDomaine = codeDomaine;
	}
	public String getCodeCycle() {
		return codeCycle;
	}
	public void setCodeCycle(String codeCycle) {
		this.codeCycle = codeCycle;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", code=" + code + ", libelle=" + libelle + ", codeSpecialite=" + codeSpecialite
				+ ", codeDomaine=" + codeDomaine + ", codeCycle=" + codeCycle + "]";
	}
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(long id, String code, String libelle, String codeSpecialite, String codeDomaine, String codeCycle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.codeSpecialite = codeSpecialite;
		this.codeDomaine = codeDomaine;
		this.codeCycle = codeCycle;
	}  
}