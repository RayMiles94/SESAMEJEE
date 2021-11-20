package sesame.workshop.sesame.workshop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import sesame.workshop.sesame.workshop.entitie.Client;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepo extends JpaRepository<Client, Long> {

}
