package sesame.jee.bank.BankApp.Controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String indexRoute() {
		return "index";
	}
	
	
}
