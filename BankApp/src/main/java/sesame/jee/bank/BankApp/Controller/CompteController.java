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
		if (cr.findAll().size()==0) {
			model.addAttribute("message", "Veuillez créer un employé et un client pour ouvrir cette page");
			return "empty_page";
		}
		if (emps.findAll().size()==0) {
			model.addAttribute("message", "Veuillez créer un employé et un client pour ouvrir cette page");
			return "empty_page";
		}
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
		model.addAttribute("update", false);
		model.addAttribute("id", false);
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
			@RequestParam("decouvertb") String decouvertb,
			@RequestParam("update")     String update,
			@RequestParam("id")         String id) {
				Optional<Client> cs = cr.findById(Long.parseLong(c));
				Optional<Employes> es = emps.findById(Long.parseLong(employees));
				Boolean updateb = Boolean.parseBoolean(update);
				if (updateb) {
					if (ctype.equals("CC")) {
						Optional<CompteCC> ucc = compteCCDAO.findById(Long.parseLong(id));
						CompteCC cc = ucc.get();
						cc.setEmployes(es.get());
						cc.setSolde(Double.parseDouble(solde));
						cc.setDecouvert(Double.parseDouble(decouvertb));
						compteCCDAO.save(cc);
					}
					else {
						Optional<CompteEP> epeeOptional = ep.findById(Long.parseLong(id));
						CompteEP ep2 = epeeOptional.get();
						ep2.setClient(cs.get());
						ep2.setEmployes(es.get());
						ep2.setSolde(Double.parseDouble(solde));
						ep.save(ep2);
					}
				}
				else  {
					if (ctype.equals("CC")) {
						CompteCC cc = new CompteCC();
						cc.setClient(cs.get());	
						cc.setEmployes(es.get());
						cc.setSolde(Double.parseDouble(solde));
						cc.setDecouvert(Double.parseDouble(decouvertb));
						compteCCDAO.save(cc);
					}
					else {
						CompteEP cc2 = new CompteEP();
						cc2.setClient(cs.get());
						cc2.setEmployes(es.get());
						cc2.setSolde(Double.parseDouble(solde));
						ep.save(cc2);
					}
				}
				return "redirect:/compte";
		
	}
	
	@GetMapping("/co/update/{type}/{id}")
	public String UpdateACCOUNT(Model model, @PathVariable String type, @PathVariable String id) {
		
		Collection<Client> ces = cr.findAll();
		Collection<Employes> empsf = emps.findAll();
		if(type.equals("CC")) {
			Optional<CompteCC> cccOptional = compteCCDAO.findById(Long.parseLong(id));
			CompteCC cccc = cccOptional.get();
			model.addAttribute("com", cccc);
		}
		else {
			Optional<CompteEP> ep111 = ep.findById(Long.parseLong(id));
			CompteEP ep1 = ep111.get();
			model.addAttribute("com", ep1);
		}
		model.addAttribute("emps", empsf);
		model.addAttribute("ces", ces);
		model.addAttribute("id", id);
		model.addAttribute("update", true);
		model.addAttribute("type", type);
		return "addcompte";
	}
	
	@GetMapping("/co/remove/{type}/{id}")
	public String removeAccount(@PathVariable String type, @PathVariable String id) {
		Long idLong = Long.parseLong(id);
		if (type.equals("CC")) {
			compteCCDAO.deleteById(idLong);
		}
		else {
			ep.deleteById(idLong);
		}
		return "redirect:/compte";
	}
	
	

}
