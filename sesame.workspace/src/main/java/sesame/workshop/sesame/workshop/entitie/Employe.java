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

}
