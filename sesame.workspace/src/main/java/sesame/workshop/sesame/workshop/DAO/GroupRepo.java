package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.workshop.sesame.workshop.entitie.Group;

public interface GroupRepo extends JpaRepository<Group, Long> {

}