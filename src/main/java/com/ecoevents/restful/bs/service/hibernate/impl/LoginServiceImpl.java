package com.ecoevents.restful.bs.service.hibernate.impl;

import org.springframework.stereotype.Service;

import com.ecoevents.restful.bs.service.hibernate.LoginService;

@Service
public class LoginServiceImpl extends AbstractServiceHibernateImpl implements LoginService{

	@Override
	public Boolean login() {
		System.out.println("Make Login");
		//findBySQLQuery("Select * FROM ", clazz, parametros)
		return false;
	}

}
