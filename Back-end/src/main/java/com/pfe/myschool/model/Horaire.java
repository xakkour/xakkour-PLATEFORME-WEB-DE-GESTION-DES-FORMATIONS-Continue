package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "horaire")
public class Horaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int  code;
	private String heure;
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
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	@Override
	public String toString() {
		return "Horaire [id=" + id + ", code=" + code + ", heure=" + heure + "]";
	}
	public Horaire(long id, int code, String heure) {
		super();
		this.id = id;
		this.code = code;
		this.heure = heure;
	}
	public Horaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
