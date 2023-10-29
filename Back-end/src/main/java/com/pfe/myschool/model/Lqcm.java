package com.pfe.myschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "lqcm")

public class Lqcm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int numero;
	private int num;
	private String question;
	private int reponse;
	private int choix1;
	private String reponse1;
	private int choix2;
	private String reponse2;
	private int choix3;
	private String reponse3;
	
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	private Qcm qcm;

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getReponse() {
		return reponse;
	}

	public void setReponse(int reponse) {
		this.reponse = reponse;
	}

	public int getChoix1() {
		return choix1;
	}

	public void setChoix1(int choix1) {
		this.choix1 = choix1;
	}

	public String getReponse1() {
		return reponse1;
	}

	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}

	public int getChoix2() {
		return choix2;
	}

	public void setChoix2(int choix2) {
		this.choix2 = choix2;
	}

	public String getReponse2() {
		return reponse2;
	}

	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}

	public int getChoix3() {
		return choix3;
	}

	public void setChoix3(int choix3) {
		this.choix3 = choix3;
	}

	public String getReponse3() {
		return reponse3;
	}

	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}

	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}

	@Override
	public String toString() {
		return "Lqcm [id=" + id + ", numero=" + numero + ", num=" + num + ", question=" + question + ", reponse="
				+ reponse + ", choix1=" + choix1 + ", reponse1=" + reponse1 + ", choix2=" + choix2 + ", reponse2="
				+ reponse2 + ", choix3=" + choix3 + ", reponse3=" + reponse3 + ", qcm=" + qcm + "]";
	}

	public Lqcm(long id, int numero, int num, String question, int reponse, int choix1, String reponse1, int choix2,
			String reponse2, int choix3, String reponse3, Qcm qcm) {
		super();
		this.id = id;
		this.numero = numero;
		this.num = num;
		this.question = question;
		this.reponse = reponse;
		this.choix1 = choix1;
		this.reponse1 = reponse1;
		this.choix2 = choix2;
		this.reponse2 = reponse2;
		this.choix3 = choix3;
		this.reponse3 = reponse3;
		this.qcm = qcm;
	}

	public Lqcm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
