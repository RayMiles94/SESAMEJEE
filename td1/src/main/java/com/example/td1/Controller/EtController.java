package com.example.td1.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.td1.DAO.EtudiantRepository;
import com.example.td1.Model.Departement;
import com.example.td1.Model.Etudiant;

@RestController
@RequestMapping(value="/etudiants")
public class EtController {
	
	@Autowired
	protected EtudiantRepository ER;
	
	
	
	@PostMapping("/AddE")
	public Etudiant ajouterE(@RequestBody Etudiant e)
	{
		return ER.save(e);
	}
	
	@GetMapping("/GetAllE")
	public List<Etudiant> afficherToutE()
	{
		return ER.findAll();
	}

	
	@GetMapping("/Q8")
	public List<Departement> question81()
	{
		return ER.parametreQ81(ER.parametreQ82().get(0));
	}


	
	@GetMapping("/Q11")
	public List<Departement> question11()
	{
		return ER.parametreQ81(ER.parametreQ11().get(0));
	}

	@GetMapping("/Q12")
	public List<Departement> question12()
	{
		return ER.parametreQ81 (Long.valueOf(0));
	}

	
}
