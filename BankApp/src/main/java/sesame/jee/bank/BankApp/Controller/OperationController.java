package sesame.jee.bank.BankApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationController {
	
	@GetMapping("/opertaion")
	public String OpRoute() {
		return "operation";
	}

}
