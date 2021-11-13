package sesame.workshop.sesame.workshop.entitie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmployeLong;
	
	private String nomEmployeString;
	
	@ManyToOne
	@JoinColumn(name = "Code_emp_sup")
	private Employe employesSup;
	
	@ManyToMany
	@JoinTable(name = "Emp_Gr", joinColumns = @JoinColumn(name = "Nump_EMP"), inverseJoinColumns= @JoinColumn())
	private Collection<Group> groupes;

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

	public Employe getEmployesSup() {
		return employesSup;
	}

	public void setEmployesSup(Employe employesSup) {
		this.employesSup = employesSup;
	}

	public Collection<Group> getGroups() {
		return groupes;
	}

	public void setGroups(Collection<Group> groups) {
		this.groupes = groups;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeEmployeLong, employesSup, groupes, nomEmployeString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(codeEmployeLong, other.codeEmployeLong) && Objects.equals(employesSup, other.employesSup)
				&& Objects.equals(groupes, other.groupes) && Objects.equals(nomEmployeString, other.nomEmployeString);
	}

	@Override
	public String toString() {
		return "Employe [codeEmployeLong=" + codeEmployeLong + ", nomEmployeString=" + nomEmployeString
				+ ", employesSup=" + employesSup + ", groups=" + groupes + "]";
	}

	
	
	
	
}
