package com.mts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mts.model.Login;
import com.mts.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService logServ;

	
	@PostMapping("/login/{username}/{password}")
	public Login loginUser(@PathVariable String username, @PathVariable String password) {
		Login login=new Login();
		try {
			login=logServ.loginWithData(username, password);
		} catch (Exception e) {
			logger.error("------------------LoginFailed---------------");
			return login;

		}
		logger.info("-----------------Login Successful----------------");
		return login;
	}

	
	@PostMapping("/Logout")
	public HttpStatus logOut() throws Exception {
		if (this.loginStatus()) {
			logServ.logoutPresentUser();
			return HttpStatus.ACCEPTED;
		} else {
			throw new Exception("User Not yet Lo gged In");
		}
	}

	
	public boolean loginStatus() {
		return logServ.loginStatus();
	}

	
	public String getRole() {
		return logServ.getRole();
	}

}