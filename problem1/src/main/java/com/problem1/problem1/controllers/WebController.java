package com.problem1.problem1.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.problem1.problem1.DAO.DepartmentDAO;
import com.problem1.problem1.DAO.EtudiantDAO;
import com.problem1.problem1.DAO.SpecialiteDAO;
import com.problem1.problem1.entities.Department;
import com.problem1.problem1.entities.Etudiant;
import com.problem1.problem1.entities.Specialite;

@Controller
public class WebController {

	@Autowired
	EtudiantDAO etudiantDAO;
	
	@Autowired
	DepartmentDAO departmentDAO;
	
	@Autowired
	SpecialiteDAO specialiteDAO;
	
	@GetMapping("/")
	public String indexRoute() {
		return "index";
	}
	
	@GetMapping("/department")
	public String DepRoute(Model model, HttpSession session) {
		List<Department> deps = departmentDAO.findAll();
		model.addAttribute("deps", deps);
		return "dep";
	}
	
	@GetMapping("/specialite")
	public String SepRoute(Model model, HttpSession session) {
		List<Specialite> spec = specialiteDAO.findAll();
		model.addAttribute("spec", spec);
		return "sep";
	}
	
	@GetMapping("/page1")
	public String page1(Model model, HttpSession session) {
		model.addAttribute("user", "name");
		return "page1";
	}

	@GetMapping("/etudiants")
	public String Etudiants(Model model) {
		List<Etudiant> etudsEtudiants = etudiantDAO.findAll();
		model.addAttribute("etudiant", etudsEtudiants);
		return "etudiants";
	}

	@GetMapping("/addetudiant")
	public String addetudiantpage(Model model) {
		model.addAttribute("save", false);
		model.addAttribute("update", false);
		return "etuform";
	}

	@PostMapping(value = "/addetudiantsubmit")
	public String addetudiantpagesubmit(@RequestParam("name") String name, @RequestParam("niveau") String niveau,
			@RequestParam("moyenne") String moyenne, @RequestParam("update") String update,
			@RequestParam("id") String id, Model model) {
		boolean updateV = Boolean.parseBoolean(update);
		try {
			if (updateV == false) {
				String nameString = name;
				Integer niveauString = Integer.parseInt(niveau);
				Double moyenneString = Double.parseDouble(moyenne);
				Etudiant etudiant = new Etudiant(nameString, niveauString, moyenneString);
				etudiantDAO.save(etudiant);
				model.addAttribute("save", true);
				model.addAttribute("update", false);
				return "etuform";
			} else {
				Optional<Etudiant> etudiant = etudiantDAO.findById(Long.parseLong(id));
				Etudiant e = etudiant.get();
				e.setNomE(name);
				e.setMoyenne(Double.parseDouble(moyenne));
				e.setNiveau(Integer.parseInt(niveau));
				etudiantDAO.save(e);
				model.addAttribute("save", false);
				model.addAttribute("update", true);
				return "redirect:/etudiants";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "etuform";
		}
	}

	@GetMapping(value = "/etdudelete/{id}")
	public String deeleteEtu(@PathVariable("id") String id) {
		try {
			etudiantDAO.deleteById(Long.parseLong(id));
			return "redirect:/etudiants";
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/etudiants";
		}
	}

	@GetMapping(value = "/updateetu/{id}")
	public String updateEtu(@PathVariable("id") String id, Model model) {
		try {
			Optional<Etudiant> etudiant = etudiantDAO.findById(Long.parseLong(id));
			model.addAttribute("name", etudiant.get().getNomE());
			model.addAttribute("niveau", etudiant.get().getNiveau());
			model.addAttribute("moy", etudiant.get().getMoyenne());
			model.addAttribute("update", true);
			model.addAttribute("id", id);
			return "etuform";
		} catch (Exception e) {
			System.out.println(e);
			return "etuform";
		}
	}

}
