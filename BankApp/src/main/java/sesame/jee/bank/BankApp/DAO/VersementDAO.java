package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.jee.bank.BankApp.entities.Versement;

public interface VersementDAO extends JpaRepository<Versement, Long> {

}
