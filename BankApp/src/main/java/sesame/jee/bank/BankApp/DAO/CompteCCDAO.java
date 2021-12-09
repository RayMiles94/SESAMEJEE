package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.jee.bank.BankApp.entities.CompteCC;

public interface CompteCCDAO extends JpaRepository<CompteCC, Long> {

}
