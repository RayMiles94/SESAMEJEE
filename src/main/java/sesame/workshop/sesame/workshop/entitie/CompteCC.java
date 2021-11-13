package sesame.workshop.sesame.workshop.entitie;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
@DiscriminatorValue("CC")
public class CompteCC extends Compte {
	
	@Column
	private double decouvert;

	
}
