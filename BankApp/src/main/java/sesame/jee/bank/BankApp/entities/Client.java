package sesame.jee.bank.BankApp.entities;

import java.io.Serializable;
import java.util.Collection;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeClient;

	private String nomClient;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Compte> comptes;

	public Client() {
	}

	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}

	public Client(Long codeClientLong2, String nomClient, Collection<Compte> comptes) {
		super();
		this.nomClient = nomClient;
		this.comptes = comptes;
	}

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClientLong(Long codeClientLong) {
		this.codeClient = codeClientLong;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Client [codeClient=" + codeClient + ", nomClient=" + nomClient + ", comptes=" + comptes + "]";
	}

}
