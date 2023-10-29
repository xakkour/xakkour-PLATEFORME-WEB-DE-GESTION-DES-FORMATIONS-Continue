package com.pfe.myschool.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListTarif {
	
	private long id;
	  private String code;
	  private String codeSpecialite;
	  private String specialite;
	  private String codeDomaine;
	  private String domaine;
	  private int    annee;
	  private double m1;
	  private double m2;
	  private double m3;
	  private double frais;	  
	  private double montant;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date d1;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date d2;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date d3;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date d4;
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
	public String getCodeSpecialite() {
		return codeSpecialite;
	}
	public void setCodeSpecialite(String codeSpecialite) {
		this.codeSpecialite = codeSpecialite;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getCodeDomaine() {
		return codeDomaine;
	}
	public void setCodeDomaine(String codeDomaine) {
		this.codeDomaine = codeDomaine;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getM1() {
		return m1;
	}
	public void setM1(double m1) {
		this.m1 = m1;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public double getM3() {
		return m3;
	}
	public void setM3(double m3) {
		this.m3 = m3;
	}
	public double getFrais() {
		return frais;
	}
	public void setFrais(double frais) {
		this.frais = frais;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		this.d2 = d2;
	}
	public Date getD3() {
		return d3;
	}
	public void setD3(Date d3) {
		this.d3 = d3;
	}
	public Date getD4() {
		return d4;
	}
	public void setD4(Date d4) {
		this.d4 = d4;
	}
	@Override
	public String toString() {
		return "ListTarif [id=" + id + ", code=" + code + ", codeSpecialite=" + codeSpecialite + ", specialite="
				+ specialite + ", codeDomaine=" + codeDomaine + ", domaine=" + domaine + ", annee=" + annee + ", m1="
				+ m1 + ", m2=" + m2 + ", m3=" + m3 + ", frais=" + frais + ", montant=" + montant + ", d1=" + d1
				+ ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4 + "]";
	}

	public ListTarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListTarif(long id, String code, String codeSpecialite, String specialite, String codeDomaine, String domaine,
			int annee, double m1, double m2, double m3, double frais, double montant, Date d1, Date d2, Date d3,
			Date d4) {
		super();
		this.id = id;
		this.code = code;
		this.codeSpecialite = codeSpecialite;
		this.specialite = specialite;
		this.codeDomaine = codeDomaine;
		this.domaine = domaine;
		this.annee = annee;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.frais = frais;
		this.montant = montant;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
	}
}
