package sesame.workshop.sesame.workshop.entitie;



import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table()
public class Compte {
	
	
	public Compte() {
		super();
	}

	public Compte(Long id, String numCompte, Date dateCreationDate, double solde) {
		super();
		this.id = id;
		this.numCompte = numCompte;
		this.dateCreationDate = dateCreationDate;
		this.solde = solde;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String numCompte;

	@Column()
	private Date dateCreationDate; 
	
	@Column()
	private double solde;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
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

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numCompte=" + numCompte + ", dateCreationDate=" + dateCreationDate + ", solde="
				+ solde + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCreationDate, id, numCompte, solde);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(dateCreationDate, other.dateCreationDate) && Objects.equals(id, other.id)
				&& Objects.equals(numCompte, other.numCompte)
				&& Double.doubleToLongBits(solde) == Double.doubleToLongBits(other.solde);
	}
	
	
}
