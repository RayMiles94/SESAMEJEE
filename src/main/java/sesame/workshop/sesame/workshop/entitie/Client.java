package sesame.workshop.sesame.workshop.entitie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeClientLong;
	
	private String nomClientString;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Compte> comptes;

	public Long getCodeClientLong() {
		return codeClientLong;
	}

	public void setCodeClientLong(Long codeClientLong) {
		this.codeClientLong = codeClientLong;
	}

	public String getNomClientString() {
		return nomClientString;
	}

	public void setNomClientString(String nomClientString) {
		this.nomClientString = nomClientString;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeClientLong, comptes, nomClientString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(codeClientLong, other.codeClientLong) && Objects.equals(comptes, other.comptes)
				&& Objects.equals(nomClientString, other.nomClientString);
	}

	public Client(Long codeClientLong, String nomClientString, Collection<Compte> comptes) {
		super();
		this.codeClientLong = codeClientLong;
		this.nomClientString = nomClientString;
		this.comptes = comptes;
	}
	
	
	
}
