package sesame.jee.bank.BankApp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeEmployeLong;
	
	private String nomEmployeString;
	
	@ManyToOne
	@JoinColumn(name="Code_emp_sup")
	private Employes employesSup;
	
	@ManyToMany
	@JoinTable(name = "Emp_Gr", joinColumns = @JoinColumn(name="Num_EMP"), inverseJoinColumns = @JoinColumn(name="Num_groupe"))
	private Collection<Groupe> groupes;
	
	public Employes() {}
	
	public Employes(String nomEmployeString) {
		super();
		this.nomEmployeString = nomEmployeString;
	}

	public Employes(String nomEmployeString, Employes employesSup, Collection<Groupe> groupes) {
		super();
		this.nomEmployeString = nomEmployeString;
		this.employesSup = employesSup;
		this.groupes = groupes;
	}

	public Long getCodeEmployeLong() {
		return codeEmployeLong;
	}

	public void setCodeEmployeLong(Long codeEmployeLong) {
		this.codeEmployeLong = codeEmployeLong;
	}

	public String getNomEmployeString() {
		return nomEmployeString;
	}

	public void setNomEmployeString(String nomEmployeString) {
		this.nomEmployeString = nomEmployeString;
	}

	public Employes getEmployesSup() {
		return employesSup;
	}

	public void setEmployesSup(Employes employesSup) {
		this.employesSup = employesSup;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	@Override
	public String toString() {
		return "Employes [codeEmployeLong=" + codeEmployeLong + ", nomEmployeString=" + nomEmployeString
				+ ", employesSup=" + employesSup + ", groupes=" + groupes + "]";
	}
	
}
