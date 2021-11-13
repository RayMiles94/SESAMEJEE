package sesame.workshop.sesame.workshop.entitie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_CRT", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte implements Serializable {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCompte;
	
	@Column
	private String dateCreation;
	
	@Column
	private Date dateCreationDate;
	
	@Column
	private double solde;
	
	@ManyToOne
	@JoinColumn(name = "Code_Cli")
	private Client client;

	@ManyToOne
	@JoinColumn(name= "Code_Emp")
	private Employe employe;
	
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;

	public Long getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(Long codeCompte) {
		this.codeCompte = codeCompte;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateCreationDate() {
		return dateCreationDate;
	}

	public void setDateCreationDate(Date dateCreationDate) {
		this.dateCreationDate = dateCreationDate;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", dateCreation=" + dateCreation + ", dateCreationDate="
				+ dateCreationDate + ", solde=" + solde + ", client=" + client + ", employe=" + employe
				+ ", operations=" + operations + "]";
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(Long codeCompte, String dateCreation, Date dateCreationDate, double solde, Client client,
			Employe employe, Collection<Operation> operations) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.dateCreationDate = dateCreationDate;
		this.solde = solde;
		this.client = client;
		this.employe = employe;
		this.operations = operations;
	}
	
	

	
	
}
