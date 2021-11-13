package sesame.workshop.sesame.workshop.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1)
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroOperationLong;
	
	private Date dateOperation;
	
	private double montant;
	
	@ManyToOne
	@JoinColumn(name = "Code_CPT")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name = "Code_Employe")
	private Employe employe;

	public Long getNumeroOperationLong() {
		return numeroOperationLong;
	}

	public void setNumeroOperationLong(Long numeroOperationLong) {
		this.numeroOperationLong = numeroOperationLong;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

		
	
	
}
