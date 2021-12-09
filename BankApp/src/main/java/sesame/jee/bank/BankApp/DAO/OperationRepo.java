package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.jee.bank.BankApp.entities.Operation;

public interface OperationRepo extends JpaRepository<Operation, Long> {

}
