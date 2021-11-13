package sesame.workshop.sesame.workshop.entitie;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.aspectj.apache.bcel.classfile.Code;

@Entity
@Table
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmploye;
	
	@Column()
	private String nomEmploye ;

	public Employe(Long codeEmploye, String nomEmploye) {
		super();
		this.codeEmploye = codeEmploye;
		this.nomEmploye = nomEmploye;
	}

	public Employe() {
		super();
	}

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	@Override
	public String toString() {
		return "Employe [codeEmploye=" + codeEmploye + ", nomEmploye=" + nomEmploye + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeEmploye, nomEmploye);
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
		return Objects.equals(codeEmploye, other.codeEmploye) && Objects.equals(nomEmploye, other.nomEmploye);
	}
	
	
	
}
