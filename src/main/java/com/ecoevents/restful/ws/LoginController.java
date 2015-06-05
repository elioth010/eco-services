package com.ecoevents.restful.ws;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecoevents.restful.bs.service.hibernate.LoginService;
import com.ecoevents.restful.eis.dto.UserDTO;

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
		return "{hello: \"this is a rest test\"}";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	public ResponseEntity<UserDTO> makeLogin(@RequestParam(value="username",required=true) String username, @RequestParam(value="password",required=true) String password){
		return getLoginService().login(username, password);
	}
	
	@RequestMapping(value="register", method= RequestMethod.POST)
	public Boolean registerUser(@RequestBody(required=true) UserDTO user){
		return getLoginService().register(user);
	}
	
	@RequestMapping(value="profile", method= RequestMethod.GET)
	public ResponseEntity<UserDTO> getProfile(@RequestParam(value="id") Integer id){
		return getLoginService().profile(id);
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
