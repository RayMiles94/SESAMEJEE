package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.workshop.sesame.workshop.entitie.Employe;

public interface EmployeeRepo extends JpaRepository<Employe, Long>{

}
