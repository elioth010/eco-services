package com.ecoevents.restful.ws;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecoevents.restful.bs.service.hibernate.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1720148964697360646L;

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String testLogin(){
		loginService.login();
		return "{helo: \"this is a rest test\"}";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
