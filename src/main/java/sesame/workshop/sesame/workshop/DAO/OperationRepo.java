package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.workshop.sesame.workshop.entitie.Operation;

public interface OperationRepo extends JpaRepository<Operation, Long> {

}
