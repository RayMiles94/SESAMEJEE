package sesame.jee.bank.BankApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.jee.bank.BankApp.entities.Employes;

public interface EmployeeDAO extends JpaRepository<Employes, Long> {

}
