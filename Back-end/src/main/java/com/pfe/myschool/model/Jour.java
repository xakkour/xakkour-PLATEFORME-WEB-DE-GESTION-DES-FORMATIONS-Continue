package com.pfe.myschool.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "jour")
public class Jour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int  code;
	private String libelle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
//	
	@Override
	public String toString() {
		return "Jour [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
public Jour(long id, int code, String libelle) {
	super();
	this.id = id;
	this.code = code;
	this.libelle = libelle;
}
public Jour() {
	super();
	// TODO Auto-generated constructor stub
}

}
