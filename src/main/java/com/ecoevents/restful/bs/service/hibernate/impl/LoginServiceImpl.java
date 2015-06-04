package com.ecoevents.restful.bs.service.hibernate.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecoevents.restful.bs.service.hibernate.LoginService;
import com.ecoevents.restful.eis.bo.User;
import com.ecoevents.restful.eis.dto.UserDTO;
import com.ecoevents.restful.util.persistence.ListaParametrosDTO;
import com.ecoevents.restful.util.persistence.Parametro;

@Service
public class LoginServiceImpl extends AbstractServiceHibernateImpl implements LoginService{
	
	private static final String MAKE_LOGIN= "makeLogin";
	//private static final String GET_FRECUENCIAS= "getFrecuencias";
	//private static final String GET_ESTADOS_CIVILES="getEstadosCiviles";
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";

	@Override
	public ResponseEntity<UserDTO> login(String username, String password) {
		System.out.println("Make Login");
		ListaParametrosDTO listaParametrosDTO = new ListaParametrosDTO();
		listaParametrosDTO.getParametros().add(new Parametro(USERNAME, username));
		listaParametrosDTO.getParametros().add(new Parametro(PASSWORD, password));
		List<User> userlist = findByQuery(MAKE_LOGIN, User.class, listaParametrosDTO);
		if(userlist.size()>0){
			return new ResponseEntity<UserDTO>(new UserDTO(userlist.get(0)), HttpStatus.OK);
		}else{
			return null;
		}
	}
	
	@Override
	public Boolean register(UserDTO userDTO) {
		User user = new User(null, userDTO.getUsername(), userDTO.getPassword(), userDTO.getName(), userDTO.getEmail(), userDTO.getAge());
		User created = (User) super.save(user);
		if(created!=null){
			return true;
		}
		return false;
	}
	
	@Override
	public ResponseEntity<UserDTO> profile(Integer id) {
		return new ResponseEntity<UserDTO>(new UserDTO((User) findById(User.class, id)),HttpStatus.OK);
	}

}
