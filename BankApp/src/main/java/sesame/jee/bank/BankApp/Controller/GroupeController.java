package sesame.jee.bank.BankApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sesame.jee.bank.BankApp.DAO.GroupeRepo;
import sesame.jee.bank.BankApp.entities.Groupe;

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
		model.addAttribute("length", groupeRepo.findAll().size() > 0);
		return "group";
	}
	
	@GetMapping("/addgroupe")
	public String addgrouperoute() {
		return "addgroup";
	}
	
	@PostMapping("/g/add")
	public String AddGroup(
			@RequestParam("id") String id,
			@RequestParam("name") String name , 
			@RequestParam("update") String update
			) {
		if(update.equals("no")) {
			Groupe g = new Groupe();
			g.setNomGroupeString(name);
			groupeRepo.save(g);
		}
		else {
			Optional<Groupe> gpsOptional = groupeRepo.findById(Long.parseLong(id));
			Groupe g = gpsOptional.get();
			g.setNomGroupeString(name);
			groupeRepo.save(g);
		}
		return "redirect:/group";
	}
	
	@GetMapping("/g/update/{id}")
	public String updaterecord(Model model, @PathVariable("id") String id) {
		Optional<Groupe> gpsOptional = groupeRepo.findById(Long.parseLong(id));
		Groupe g = gpsOptional.get();
		model.addAttribute("name", g.getNomGroupeString());
		model.addAttribute("update", "yes");
		model.addAttribute("id", id);
		model.addAttribute("list", g.getEmployes());
		return "addgroup";
	}
	
	@GetMapping("/g/remove/{id}")
	public String RemoveById(@PathVariable("id") Long id) {
		groupeRepo.deleteById(id);
		return "redirect:/group";
	}

}
