package sesame.jee.bank.BankApp.service;


import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.jee.bank.BankApp.DAO.ClientRepo;
import sesame.jee.bank.BankApp.DAO.CompateEPDAO;
import sesame.jee.bank.BankApp.DAO.CompteCCDAO;
import sesame.jee.bank.BankApp.DAO.EmployeeDAO;
import sesame.jee.bank.BankApp.DAO.GroupeRepo;
import sesame.jee.bank.BankApp.DAO.OperationRepo;
import sesame.jee.bank.BankApp.DAO.RetraitDAO;
import sesame.jee.bank.BankApp.DAO.VersementDAO;

@Service
public class IndexService {

	public ClientRepo clientRepo;
	public CompateEPDAO compateEPDAO;
	public CompteCCDAO compteCCDAO;
	public EmployeeDAO employeeDAO;
	public GroupeRepo groupeRepo;
	public RetraitDAO retraitDAO;
	public VersementDAO versementDAO;
	
	@Autowired
	public IndexService( ClientRepo clientRepo,
	 CompateEPDAO compateEPDAO,
	 CompteCCDAO compteCCDAO,
	 EmployeeDAO employeeDAO,
	 GroupeRepo groupeRepo,
	 OperationRepo operationRepo,
	 RetraitDAO retraitDAO,
	 VersementDAO versementDAO) {
		 this.clientRepo = clientRepo;
		 this.compateEPDAO = compateEPDAO;
		 this.compteCCDAO = compteCCDAO;
		 this.employeeDAO = employeeDAO;
		 this.groupeRepo = groupeRepo;
		 this.retraitDAO = retraitDAO;
		 this.versementDAO = versementDAO;
	}
	
	public HashMap<String, Object> getCountofdata() {
		HashMap<String, Object> counts = new HashMap<String, Object>();
		counts.put("client", clientRepo.findAll().size());
		counts.put("ep", compateEPDAO.findAll().size());
		counts.put("cc", compteCCDAO.findAll().size());
		counts.put("emp", clientRepo.findAll().size());
		counts.put("ret", retraitDAO.findAll().size());
		counts.put("ver", versementDAO.findAll().size());
		counts.put("groups", groupeRepo.findAll().size());
		return counts;
	}
	
	
}
