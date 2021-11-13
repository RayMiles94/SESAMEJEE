package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import sesame.workshop.sesame.workshop.entitie.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {

}
