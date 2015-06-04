package com.ecoevents.restful.bs.service.hibernate;

import org.springframework.http.ResponseEntity;

import com.ecoevents.restful.eis.dto.UserDTO;

public interface LoginService {
	public ResponseEntity<UserDTO> login(String username, String password);
	public Boolean register(UserDTO userDTO);
	public ResponseEntity<UserDTO> profile(Integer id);
}