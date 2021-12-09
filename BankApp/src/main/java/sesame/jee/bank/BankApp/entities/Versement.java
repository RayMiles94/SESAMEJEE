package sesame.jee.bank.BankApp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("v")
public class Versement extends Operation {

}
