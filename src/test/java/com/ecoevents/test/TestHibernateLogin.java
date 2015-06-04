package com.ecoevents.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ecoevents.restful.bs.service.hibernate.AbstractServiceHibernate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/ecoevents/restful/bs/spring/applicationContext-*.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestHibernateLogin {

	// @Autowired
	// AbstractServiceHibernate abstractServiceHibernate;
	@Autowired
	AbstractServiceHibernate interesadosService;

	public TestHibernateLogin() {

	}

	@Test
	public void TestGetProject() {

	}

	public AbstractServiceHibernate getInteresadosService() {
		return interesadosService;
	}

	public void setInteresadosService(AbstractServiceHibernate interesadosService) {
		this.interesadosService = interesadosService;
	}

}
