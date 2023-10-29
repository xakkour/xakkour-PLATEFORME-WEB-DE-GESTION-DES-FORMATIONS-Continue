package com.pfe.myschool.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Tarif",
uniqueConstraints= {
		@UniqueConstraint(columnNames="code")
}
)
public class Tarif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String codeSpecialite;
	private String codeDomaine;
	private int annee;
	private double frais;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone ="GMT")
	private Date d1;
	private double m1;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone ="GMT")
	private Date d2;
	private double m2;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone ="GMT")
	private Date d3;
	private double m3;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone ="GMT")
	private Date d4;
	private double montant;
	private int remise;
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
	public String getCodeDomaine() {
		return codeDomaine;
	}
	public void setCodeDomaine(String codeDomaine) {
		this.codeDomaine = codeDomaine;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getFrais() {
		return frais;
	}
	public void setFrais(double frais) {
		this.frais = frais;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public double getM1() {
		return m1;
	}
	public void setM1(double m1) {
		this.m1 = m1;
	}
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		this.d2 = d2;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public Date getD3() {
		return d3;
	}
	public void setD3(Date d3) {
		this.d3 = d3;
	}
	public double getM3() {
		return m3;
	}
	public void setM3(double m3) {
		this.m3 = m3;
	}
	public Date getD4() {
		return d4;
	}
	public void setD4(Date d4) {
		this.d4 = d4;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getRemise() {
		return remise;
	}
	public void setRemise(int remise) {
		this.remise = remise;
	}
	@Override
	public String toString() {
		return "Tarif [id=" + id + ", code=" + code + ", codeSpecialite=" + codeSpecialite + ", codeDomaine="
				+ codeDomaine + ", annee=" + annee + ", frais=" + frais + ", d1=" + d1 + ", m1=" + m1 + ", d2=" + d2
				+ ", m2=" + m2 + ", d3=" + d3 + ", m3=" + m3 + ", d4=" + d4 + ", montant=" + montant + ", remise="
				+ remise + "]";
	}

	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarif(long id, String code, String codeSpecialite, String codeDomaine, int annee, double frais, Date d1,
			double m1, Date d2, double m2, Date d3, double m3, Date d4, double montant, int remise) {
		super();
		this.id = id;
		this.code = code;
		this.codeSpecialite = codeSpecialite;
		this.codeDomaine = codeDomaine;
		this.annee = annee;
		this.frais = frais;
		this.d1 = d1;
		this.m1 = m1;
		this.d2 = d2;
		this.m2 = m2;
		this.d3 = d3;
		this.m3 = m3;
		this.d4 = d4;
		this.montant = montant;
		this.remise = remise;
	}
}
