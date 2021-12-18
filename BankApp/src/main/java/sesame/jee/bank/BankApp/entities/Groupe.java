package sesame.jee.bank.BankApp.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Groupes")
public class Groupe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeGroupe;
	
	private String nomGroupeString;
	
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employes> employes;
	
	public Groupe() {}
	
	public Groupe(String nomString) {
		this.nomGroupeString = nomString;
	}

	public Groupe(String nomGroupeString, Collection<Employes> employes) {
		super();
		this.nomGroupeString = nomGroupeString;
		this.employes = employes;
	}

	public Long getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getNomGroupeString() {
		return nomGroupeString;
	}

	public void setNomGroupeString(String nomGroupeString) {
		this.nomGroupeString = nomGroupeString;
	}

	public Collection<Employes> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employes> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Groupe [codeGroupe=" + codeGroupe + ", nomGroupeString=" + nomGroupeString + ", employes=" + employes
				+ "]";
	}

}
