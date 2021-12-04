package com.problem1.problem1.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


import com.problem1.problem1.entities.Etudiant;

@RepositoryRestController
public interface EtudiantDAO extends JpaRepository<Etudiant, Long>{
	
	/* URL=> http://localhost:4500/etudiants/search/q1 */
	@RestResource(path = "q1", rel = "q1")
	@Query("select e from Etudiant e where e.department.Nom = 'informatique' order by dateentre")
	public List<Etudiant> question1();

	
	/* URL=> http://localhost:4500/etudiants/search/q2 */
	@RestResource(path = "q2", rel = "q2")
	@Query("select e from Etudiant e where e.NomE like '%L%' or e.NomE like '%M%'")
	public List<Etudiant> question2();
	
	/* URL=> http://localhost:4500/etudiants/search/q3 */
	@RestResource(path = "q3", rel = "q3")
	@Query("select e from Etudiant e order by e.dateentre asc ")
	public List<Etudiant> question3();
	
	/* URL=> http://localhost:4500/etudiants/search/q4 */
	@RestResource(path = "q4", rel = "q4")
	@Query("select e  from Etudiant e order by e.dateentre asc ")
	public List<Etudiant> question4();
	
	/* URL=> http://localhost:4500/etudiants/search/q5 */
	@RestResource(path = "q5", rel = "q5")
	@Query("select AVG(e.moyenne)  from Etudiant e")
	public double question5();
	
	/* URL=> http://localhost:4500/etudiants/search/q6 */
	@RestResource(path = "q6", rel = "q6")
	@Query("select e  from Etudiant e order by moyenne desc")
	public List<Etudiant> question6();
	
	
	/* URL=> http://localhost:4500/etudiants/search/q7 */
	@RestResource(path = "q7", rel = "q7")
	@Query("select count(e) from Etudiant e group by e.department")
	public List<Object> question7();
	


}
