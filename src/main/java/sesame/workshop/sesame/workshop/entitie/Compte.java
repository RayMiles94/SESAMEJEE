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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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

	
	
}
