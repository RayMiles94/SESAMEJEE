package com.problem1.problem1.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.problem1.problem1.entities.Etudiant;



@RepositoryRestController
public interface EtudiantDAO extends JpaRepository<Etudiant, Long>{
	
	/* URL=> http://localhost:4500/api/Etudiant/search/q1 */
	@RestResource(path = "q1", rel = "q1")
	@Query("select e from Etudiant e")
	public List<Etudiant> findbydateEntree();

}
