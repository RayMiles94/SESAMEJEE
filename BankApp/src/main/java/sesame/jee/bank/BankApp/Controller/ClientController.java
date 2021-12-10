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

import sesame.jee.bank.BankApp.entities.Client;

import sesame.jee.bank.BankApp.DAO.ClientRepo;

@Controller
public class ClientController {
	
	public ClientRepo ClientRepo;
	
	@Autowired
	public  ClientController(ClientRepo ClientRepo) {
		this.ClientRepo = ClientRepo;
	}
	
	@GetMapping("/client")
	public String ClientRoute(Model model) {
		Collection<Client> clients = ClientRepo.findAll();
		model.addAttribute("length", clients.size() != 0);
		model.addAttribute("clients", clients);
		return "client";
	}
	
	@GetMapping("/addclient")
	public String ADDClientRoute(Model model) {
		model.addAttribute("update", false);
		return "addclient";
	}
	
	@PostMapping("/c/add")
	public String ADDClientRoutebackend(
			@RequestParam("name") String name,
			@RequestParam("id") String id, 
			@RequestParam("update") String u,
			Model model
			) {
		Boolean update = Boolean.parseBoolean(u);
		if (update==false) {
			Client  client1 =  new Client(name);
			ClientRepo.save(client1);
		}
		else {
			Long idLong = Long.parseLong(id);
			Optional<Client> clients = ClientRepo.findById(idLong);
			Client client2 = clients.get();
			client2.setNomClient(name);
			ClientRepo.save(client2);
		}
		return "redirect:/client";
	}
	
	@GetMapping("/c/remove/{id}")
	public String RemoveClientRoutebackend(@PathVariable String id) {
		Long idLong = Long.parseLong(id);
		ClientRepo.deleteById(idLong);
		return "redirect:/client";
	}
	
	@GetMapping("/c/update/{id}")
	public String UpdateClientRoutebackend(@PathVariable String id, Model model) {
		Long idLong = Long.parseLong(id);
		Optional<Client> clients = ClientRepo.findById(idLong);
		Client client = clients.get();
		model.addAttribute("name", client.getNomClient());
		model.addAttribute("id", client.getCodeClient());
		model.addAttribute("update", true);
		return "addclient";
	}

}
