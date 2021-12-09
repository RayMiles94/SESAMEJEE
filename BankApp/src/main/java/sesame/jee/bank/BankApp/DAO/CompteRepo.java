package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.jee.bank.BankApp.entities.Compte;

public interface CompteRepo extends JpaRepository<Compte, Long> {

}
