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
@Table(name = "event",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "numero"
				+ ""),
		@UniqueConstraint(columnNames = "libelle")
	})

public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int annee;
	private int numero;
	private String libelle;
	private String lieu;
	private String ville;
	private String pays;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	 private Date dateDebut;
	private int nbj;
    private String typeEvent;
    private double tarif;
    private int nombre;
	private String fileName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public int getNbj() {
		return nbj;
	}
	public void setNbj(int nbj) {
		this.nbj = nbj;
	}
	public String getTypeEvent() {
		return typeEvent;
	}
	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", annee=" + annee + ", numero=" + numero + ", libelle=" + libelle + ", lieu=" + lieu
				+ ", ville=" + ville + ", pays=" + pays + ", dateDebut=" + dateDebut + ", nbj=" + nbj + ", typeEvent="
				+ typeEvent + ", tarif=" + tarif + ", nombre=" + nombre + ", fileName=" + fileName + "]";
	}
	public Event(long id, int annee, int numero, String libelle, String lieu, String ville, String pays, Date dateDebut,
			int nbj, String typeEvent, double tarif, int nombre, String fileName) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.libelle = libelle;
		this.lieu = lieu;
		this.ville = ville;
		this.pays = pays;
		this.dateDebut = dateDebut;
		this.nbj = nbj;
		this.typeEvent = typeEvent;
		this.tarif = tarif;
		this.nombre = nombre;
		this.fileName = fileName;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
