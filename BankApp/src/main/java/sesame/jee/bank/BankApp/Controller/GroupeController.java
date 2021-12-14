package sesame.jee.bank.BankApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sesame.jee.bank.BankApp.DAO.GroupeRepo;

@Controller
public class GroupeController {
	
	public GroupeRepo groupeRepo;
	
	@Autowired
	public GroupeController(GroupeRepo groupeRepo) {
		this.groupeRepo = groupeRepo;
	}
	
	
	@GetMapping("/group")
	public String GroupeControllerRoute(Model model) {
		model.addAttribute("groups", groupeRepo.findAll());
		model.addAttribute("length", groupeRepo.findAll().size());
		return "group";
	}

}
