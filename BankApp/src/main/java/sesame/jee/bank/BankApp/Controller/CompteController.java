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

import sesame.jee.bank.BankApp.DAO.ClientRepo;
import sesame.jee.bank.BankApp.DAO.CompateEPDAO;
import sesame.jee.bank.BankApp.DAO.CompteCCDAO;
import sesame.jee.bank.BankApp.DAO.EmployeeDAO;
import sesame.jee.bank.BankApp.entities.Client;
import sesame.jee.bank.BankApp.entities.CompteCC;
import sesame.jee.bank.BankApp.entities.CompteEP;
import sesame.jee.bank.BankApp.entities.Employes;

@Controller
public class CompteController {
	
	public CompteCCDAO compteCCDAO;
	public CompateEPDAO ep;
	public ClientRepo cr;
	public EmployeeDAO emps;
	
	@Autowired
	public  CompteController(CompteCCDAO cc, CompateEPDAO ep, ClientRepo cr, EmployeeDAO e) {
		this.compteCCDAO = cc;
		this.ep = ep;
		this.cr = cr;
		this.emps = e;
	}
	
	@GetMapping("/compte")
	public String CPRoute(Model model) {
		Collection<CompteCC> cc = compteCCDAO.findAll();
		Collection<CompteEP> epa = ep.findAll();
	    Boolean lengthBoolean = cc.size() == 0 && epa.size() == 0;
	    model.addAttribute("length", lengthBoolean);
	    model.addAttribute("comptes1", cc);
	    model.addAttribute("comptes2", epa);
		return "compte";
	}
	
	@GetMapping("/addcompte")
	public String addcompteroute(Model model) {
		model.addAttribute("update", false);
		Collection<Client> ces = cr.findAll();
		Collection<Employes> empsf = emps.findAll();
		model.addAttribute("emps", empsf);
		model.addAttribute("ces", ces);
		return "addcompte";
	}
	
	@PostMapping("/co/add")
	public String postcompte(
			Model model,
			@RequestParam("client") 	String c,
			@RequestParam("employees") 	String employees,
			@RequestParam("solde") 		String solde,
			@RequestParam("ctype") 		String ctype,
			@RequestParam("decouvertb") String decouvertb) {
				System.out.print(c);
				System.out.print(employees);
				System.out.print(solde);
				System.out.print(ctype);
				System.out.print(decouvertb);
				model.addAttribute("update", false);
				if (ctype=="CC") {
					CompteCC cc = new CompteCC();
					Optional<Client> cs = cr.findById(Long.parseLong(c));
					cc.setClient(cs.get());
					Optional<Employes> es = emps.findById(Long.parseLong(employees));
					cc.setEmployes(es.get());
					cc.setSolde(Double.parseDouble(solde));
					cc.setDecouvert(Double.parseDouble(decouvertb));
					compteCCDAO.save(cc);
				}
				else {
					CompteEP cc2 = new CompteEP();
					Optional<Client> cs = cr.findById(Long.parseLong(c));
					cc2.setClient(cs.get());
					Optional<Employes> es = emps.findById(Long.parseLong(employees));
					cc2.setEmployes(es.get());
					cc2.setSolde(Double.parseDouble(solde));
					ep.save(cc2);
				}
				return "redirect:/compte";
		
	}
	
	@GetMapping("/co/remove/{type}/{id}")
	public String removeAccount(@PathVariable String type, @PathVariable String id) {
		Long idLong = Long.parseLong(id);
		if (type=="CC") {
			compteCCDAO.deleteById(idLong);
		}
		else {
			ep.deleteById(idLong);
		}
		return "redirect:/compte";
	}
	
	

}
