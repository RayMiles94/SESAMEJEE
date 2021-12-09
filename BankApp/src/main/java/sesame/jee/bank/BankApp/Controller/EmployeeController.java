package sesame.jee.bank.BankApp.Controller;

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
import sesame.jee.bank.BankApp.entities.Client;
import sesame.jee.bank.BankApp.entities.Employes;

@Controller
public class EmployeeController {
	
	public EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/employee")
	public String EmpRoute(Model model) {
		Collection<Employes> clients = employeeDAO.findAll();
		model.addAttribute("length", clients.size() != 0);
		model.addAttribute("emps", clients);
		return "employee";
	}
	
	@GetMapping("/addemp")
	public String ADDempRoute(Model model) {
		model.addAttribute("update", false);
		return "addemp";
	}
	
	@PostMapping("/e/add")
	public String ADDClientRoutebackend(
			@RequestParam("name") String name,
			@RequestParam("id") String id, 
			@RequestParam("update") String u,
			Model model
			) {
		Boolean update = Boolean.parseBoolean(u);
		if (update==false) {
			Employes  emp1 =  new Employes(name);
			employeeDAO.save(emp1);
		}
		else {
			Long idLong = Long.parseLong(id);
			Optional<Employes> emps = employeeDAO.findById(idLong);
			Employes emp2 = emps.get();
			emp2.setNomEmployeString(name);
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
		model.addAttribute("update", true);
		return "addemp";
	}
	
	
}
