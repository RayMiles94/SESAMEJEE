package sesame.jee.bank.BankApp.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sesame.jee.bank.BankApp.service.LoginService;

@Controller
public class LoginPage {
	
	@Autowired
	public LoginService loginService;

	
	@GetMapping("/login")
	public String loginroute(HttpSession session) {
		return "login";
	}
	
	@PostMapping("/web/login")
	public String LoginRouteSubmit(Model model, @RequestParam("login") String login, @RequestParam("password") String password, HttpSession session) {
		loginService.setLogin(login);
		loginService.setPassword(password);
		if(loginService.checkifcorrect()) {
			session.setAttribute("login", "true");
			return "redirect:/";
		}
		model.addAttribute("error", "error");
		return "login";
	}
	
	@GetMapping("/dec")
	public String dec(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/login";
	}
	
}
