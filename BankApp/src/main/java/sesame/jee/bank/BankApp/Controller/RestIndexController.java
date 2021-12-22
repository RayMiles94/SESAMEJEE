package sesame.jee.bank.BankApp.Controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sesame.jee.bank.BankApp.service.IndexService;


@RestController
public class RestIndexController {
	
	@Autowired
	public IndexService indexService;
	
	@PostMapping("/index/getcount")
	public HashMap<String, Object> getcounts(){
		return indexService.getCountofdata();
	}
	

}
