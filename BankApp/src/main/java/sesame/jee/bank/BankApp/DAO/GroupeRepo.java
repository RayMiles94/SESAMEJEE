package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.jee.bank.BankApp.entities.Groupe;

public interface GroupeRepo extends JpaRepository<Groupe, Long>{

}
