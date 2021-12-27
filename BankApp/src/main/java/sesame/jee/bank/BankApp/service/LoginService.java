package sesame.jee.bank.BankApp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private String login;
	private String password;
	
	public LoginService() {}
	
	public LoginService(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public boolean checkifcorrect() {
		if(this.login.equals("admin")  && this.password.equals("admin") ) return true;
		else return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginService [login=" + login + ", password=" + password + "]";
	}
	
}
