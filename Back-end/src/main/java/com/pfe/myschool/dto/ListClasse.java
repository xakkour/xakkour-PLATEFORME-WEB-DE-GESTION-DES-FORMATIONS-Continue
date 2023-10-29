package com.pfe.myschool.dto;

public class ListClasse {
	
	 
	
	public ListClasse(long id, String code, String libelle, String codeSpecialite, String codeDomaine, String codeCycle,
			String specialite, String domaine, String cycle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.codeSpecialite = codeSpecialite;
		this.codeDomaine = codeDomaine;
		this.codeCycle = codeCycle;
		this.specialite = specialite;
		this.domaine = domaine;
		this.cycle = cycle;
	}
	private long id;
	  private String code;
	  private String libelle;
	  private String codeSpecialite;
	  private String codeDomaine;
	  private String codeCycle;
	  private String specialite;
	  private String domaine;
	 
	  private String cycle;
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
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getCodeCycle() {
		return codeCycle;
	}
	public void setCodeCycle(String codeCycle) {
		this.codeCycle = codeCycle;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	
}