package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.workshop.sesame.workshop.entitie.Compte;

public interface CompteRepo extends JpaRepository<Compte, Long> {

}
