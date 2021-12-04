package com.problem1.problem1.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String Nom;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", Nom=" + Nom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Nom, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(Nom, other.Nom) && Objects.equals(id, other.id);
	}

	public Department(Long id, String nom) {
		super();
		this.id = id;
		Nom = nom;
	}
	
	public Department() {
	}
	
	
}
