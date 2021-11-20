package com.problem1.problem1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Etudiant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String NomE;
	
	private int niveau;

	private Date dateentre;
	
	private double moyenne;
	
	@ManyToOne()
	private Specialite sepSpecialite;
	
	@ManyToOne()
	private Department department;
	
	public Etudiant() {
		
	}

	public Etudiant(String nomE, int niveau, Date dateentre, double moyenne, Specialite sepSpecialite,
			Department department) {
		super();
		NomE = nomE;
		this.niveau = niveau;
		this.dateentre = dateentre;
		this.moyenne = moyenne;
		this.sepSpecialite = sepSpecialite;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomE() {
		return NomE;
	}

	public void setNomE(String nomE) {
		NomE = nomE;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Date getDateentre() {
		return dateentre;
	}

	public void setDateentre(Date dateentre) {
		this.dateentre = dateentre;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public Specialite getSepSpecialite() {
		return sepSpecialite;
	}

	public void setSepSpecialite(Specialite sepSpecialite) {
		this.sepSpecialite = sepSpecialite;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
}
