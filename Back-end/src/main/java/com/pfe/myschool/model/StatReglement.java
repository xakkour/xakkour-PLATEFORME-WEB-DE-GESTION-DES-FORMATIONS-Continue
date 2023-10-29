package com.pfe.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatReglement")
public class StatReglement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int n;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "StatReglement [id=" + id + ", n=" + n + "]";
	}

	public StatReglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatReglement(long id, int n) {
		super();
		this.id = id;
		this.n = n;
	}
}
