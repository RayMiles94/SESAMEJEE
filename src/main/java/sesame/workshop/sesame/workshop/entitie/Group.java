package sesame.workshop.sesame.workshop.entitie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Groupes")
public class Group implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeGroupeLong;
	
	private String nomGroupeString;
	
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employe> employes;

	public Long getCodeGroupeLong() {
		return codeGroupeLong;
	}

	public void setCodeGroupeLong(Long codeGroupeLong) {
		this.codeGroupeLong = codeGroupeLong;
	}

	public String getNomGroupeString() {
		return nomGroupeString;
	}

	public void setNomGroupeString(String nomGroupeString) {
		this.nomGroupeString = nomGroupeString;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Group [codeGroupeLong=" + codeGroupeLong + ", nomGroupeString=" + nomGroupeString + ", employes="
				+ employes + "]";
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(Long codeGroupeLong, String nomGroupeString, Collection<Employe> employes) {
		super();
		this.codeGroupeLong = codeGroupeLong;
		this.nomGroupeString = nomGroupeString;
		this.employes = employes;
	}
	
	
	
}
