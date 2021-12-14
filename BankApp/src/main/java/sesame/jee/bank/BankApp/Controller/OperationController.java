package sesame.jee.bank.BankApp.Controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sesame.jee.bank.BankApp.DAO.CompateEPDAO;
import sesame.jee.bank.BankApp.DAO.CompteCCDAO;
import sesame.jee.bank.BankApp.DAO.EmployeeDAO;
import sesame.jee.bank.BankApp.DAO.RetraitDAO;
import sesame.jee.bank.BankApp.DAO.VersementDAO;
import sesame.jee.bank.BankApp.entities.CompteCC;
import sesame.jee.bank.BankApp.entities.CompteEP;
import sesame.jee.bank.BankApp.entities.Employes;
import sesame.jee.bank.BankApp.entities.Retrait;
import sesame.jee.bank.BankApp.entities.Versement;

@Controller
public class OperationController {
	
	
	public RetraitDAO rDao;
	public VersementDAO vDao;
	public CompteCCDAO ccdao;
	public CompateEPDAO comdao;
	public EmployeeDAO employeeDAO;
	public RetraitDAO retraitDAO;
	public VersementDAO versementDAO;
	
	@Autowired
	public OperationController(RetraitDAO r, VersementDAO v, CompteCCDAO ccdao, CompateEPDAO comdao, EmployeeDAO employeeDAO, RetraitDAO retraitDAO, VersementDAO versementDAO) {
		this.rDao = r;
		this.vDao = v;
		this.ccdao = ccdao;
		this.comdao = comdao;
		this.employeeDAO = employeeDAO;
		this.retraitDAO =retraitDAO;
		this.versementDAO = versementDAO;
	}
	
	@GetMapping("/operation")
	public String OpRoute(Model model) {
		Collection<Retrait> rf = rDao.findAll();
		Collection<Versement> vf = vDao.findAll();
		model.addAttribute("length", rf.size() > 0 || vf.size() > 0);
		model.addAttribute("ret", rf);
		model.addAttribute("vef", vf);	
		return "operation";
	}
	
	@GetMapping("/addoperation")
	public String ADDOperationroute(Model model) {
		model.addAttribute("coma", ccdao.findAll());
		model.addAttribute("comb", comdao.findAll());
		model.addAttribute("emp", employeeDAO.findAll());
		return "addoperation";
	}
	
	@PostMapping("/op/dd")
	public String PostOp(
			@RequestParam("empid") 	 String emp,
			@RequestParam("com") 	 String com,
			@RequestParam("type") 	 String t,
			@RequestParam("montant") String montant,
			Model model
	) {
		Optional<Employes> empOptional = this.employeeDAO.findById(Long.parseLong(emp));
		Employes e = empOptional.get();
		String[] parts = com.split("/");
		double mDouble = Double.parseDouble(montant);
		if(parts[0].equals("cc")) {
			System.out.println(Long.parseLong(parts[1]));
			Optional<CompteCC> ccOptional = ccdao.findById(Long.parseLong(parts[1]));
			CompteCC c1 = ccOptional.get();
			if(t.equals("versement")) {
				c1.setaddmontant(mDouble);
				ccdao.save(c1);
				Versement versement = new Versement(mDouble, c1, e);
				versementDAO.save(versement);
			}
			else {
				if (c1.getSolde()<0) {
					model.addAttribute("error", "solde");
					return "addoperation";
				}
				c1.setsubmontant(mDouble);
				ccdao.save(c1);
				Retrait retrait = new Retrait(mDouble, c1, e);
				retraitDAO.save(retrait);
			}
			
		}
		else {
			Optional<CompteEP> ccOptional = comdao.findById(Long.parseLong(parts[1]));
			CompteEP c1 = ccOptional.get();
			if(t.equals("versement")) {
				c1.setaddmontant(mDouble);
				comdao.save(c1);
				Versement versement = new Versement(mDouble, c1, e);
				versementDAO.save(versement);
			}
			else {
				if (c1.getSolde()<0) {
					model.addAttribute("error", "solde");
					return "addoperation";
				}
				c1.setsubmontant(mDouble);
				comdao.save(c1);
				Retrait retrait = new Retrait(mDouble, c1, e);
				retraitDAO.save(retrait);
			}
		}
		return "redirect:/operation";
	}
	
}
