package sesame.jee.bank.BankApp.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sesame.jee.bank.BankApp.DAO.RetraitDAO;
import sesame.jee.bank.BankApp.DAO.VersementDAO;
import sesame.jee.bank.BankApp.entities.Retrait;
import sesame.jee.bank.BankApp.entities.Versement;

@Controller
public class OperationController {
	
	
	public RetraitDAO rDao;
	public VersementDAO vDao;
	
	@Autowired
	public OperationController(RetraitDAO r, VersementDAO v) {
		this.rDao = r;
		this.vDao = v;
	}
	
	@GetMapping("/operation")
	public String OpRoute(Model model) {
		Collection<Retrait> rf = rDao.findAll();
		Collection<Versement> vf = vDao.findAll();
		model.addAttribute("length", rf.size() > 0 && vf.size() > 0);
		model.addAttribute("ret", rf);
		model.addAttribute("vef", vf);	
		return "operation";
	}
	
	
	

}
