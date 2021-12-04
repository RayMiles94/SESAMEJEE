package com.problem1.problem1.controllers;

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.problem1.problem1.DAO.EtudiantDAO;

@RestController
public class IndexController {
	
	@Autowired
	EtudiantDAO etudiantDAO;
	
	
	
	@GetMapping("/numberofemployeebydep")
	public LinkedHashMap<String, Object> numberofemployeebydep() {
		LinkedHashMap<String, Object>  reponseHashMap = new LinkedHashMap<String, Object> ();
		reponseHashMap.put("Message", etudiantDAO.question7());
		return reponseHashMap;
	}
	
	

}
