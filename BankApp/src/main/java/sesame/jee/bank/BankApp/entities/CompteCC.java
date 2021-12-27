package sesame.jee.bank.BankApp.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCC extends Compte {

	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCC() {
		super();
	}

	public CompteCC(double solde, Client client, Employes employes, double decouvert) {
		super(solde, client, employes);
		this.decouvert = decouvert;
	}

	public CompteCC(String dateCreation, double solde, Client client, Employes employes,
			Collection<Operation> operations, double decouvert) {
		super(dateCreation, solde, client, employes, operations);
		this.decouvert = decouvert;
	}

}
