package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.jee.bank.BankApp.entities.Retrait;

public interface RetraitDAO extends JpaRepository<Retrait, Long> {

}
