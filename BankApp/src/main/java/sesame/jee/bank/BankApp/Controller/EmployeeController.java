package sesame.jee.bank.BankApp.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sesame.jee.bank.BankApp.DAO.EmployeeDAO;
import sesame.jee.bank.BankApp.DAO.GroupeRepo;
import sesame.jee.bank.BankApp.entities.Client;
import sesame.jee.bank.BankApp.entities.Employes;
import sesame.jee.bank.BankApp.entities.Groupe;

@Controller
public class EmployeeController {

	public EmployeeDAO employeeDAO;
	public GroupeRepo groupeRepo;

	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO, GroupeRepo groupeRepo) {
		this.employeeDAO = employeeDAO;
		this.groupeRepo = groupeRepo;
	}

	@GetMapping("/employee")
	public String EmpRoute(Model model) {
		if (groupeRepo.findAll().size() == 0) {
			model.addAttribute("message", "Veuillez créer un employé et un client pour ouvrir cette page");
			return "empty_page";
		}
		Collection<Employes> clients = employeeDAO.findAll();
		model.addAttribute("length", clients.size() != 0);
		model.addAttribute("emps", clients);
		return "employee";
	}

	@GetMapping("/addemp")
	public String ADDempRoute(Model model) {
		model.addAttribute("update", false);
		model.addAttribute("groups", groupeRepo.findAll());
		return "addemp";
	}

	@PostMapping("/e/add")
	public String ADDClientRoutebackend(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("update") String u, @RequestParam("group") String g, Model model) {
		Boolean update = Boolean.parseBoolean(u);
		if (update == false) {
			Employes emp1 = new Employes(name);
			Optional<Groupe> gps = groupeRepo.findById(Long.parseLong(g));
			Collection<Groupe> gCollection = new ArrayList<Groupe>();
			gCollection.add(gps.get());
			emp1.setGroupes(gCollection);
			employeeDAO.save(emp1);
		} else {
			Long idLong = Long.parseLong(id);
			Optional<Employes> emps = employeeDAO.findById(idLong);
			Employes emp2 = emps.get();
			emp2.setNomEmployeString(name);
			Optional<Groupe> gps = groupeRepo.findById(Long.parseLong(g));
			Collection<Groupe> gCollection = new ArrayList<Groupe>();
			gCollection.add(gps.get());
			emp2.setGroupes(gCollection);
			employeeDAO.save(emp2);
		}
		return "redirect:/employee";
	}

	@GetMapping("/e/remove/{id}")
	public String RemoveEmpRoutebackend(@PathVariable String id) {
		Long idLong = Long.parseLong(id);
		employeeDAO.deleteById(idLong);
		return "redirect:/employee";
	}

	@GetMapping("/e/update/{id}")
	public String UpdateEmpRoutebackend(@PathVariable String id, Model model) {
		Long idLong = Long.parseLong(id);
		Optional<Employes> emps = employeeDAO.findById(idLong);
		Employes e = emps.get();
		model.addAttribute("name", e.getNomEmployeString());
		model.addAttribute("id", e.getCodeEmployeLong());
		model.addAttribute("gid", e.getGroupes().iterator().next().getCodeGroupe());
		model.addAttribute("groups", groupeRepo.findAll());
		model.addAttribute("update", true);
		return "addemp";
	}

}
