/**
 * 
 */
package com.ecoevents.restful.bs.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoevents.restful.bs.dao.AbstractDaoHibernate;
import com.ecoevents.restful.bs.service.hibernate.AbstractServiceHibernate;
import com.ecoevents.restful.eis.bo.base.BaseEntity;
import com.ecoevents.restful.util.persistence.ListaParametrosDTO;

/**
 * @author developer
 * 
 */
@Service
public class AbstractServiceHibernateImpl implements AbstractServiceHibernate {

	@Autowired
	private AbstractDaoHibernate abstractDaoHibernate;

	@Override
	public <T> BaseEntity save(BaseEntity baseEntity) {
		return this.getAbstractDaoHibernate().save(baseEntity);
	}

	@Override
	public void update(BaseEntity baseEntity) {
		this.getAbstractDaoHibernate().update(baseEntity);
	}

	@Override
	public void delete(BaseEntity baseEntity) {
		this.getAbstractDaoHibernate().delete(baseEntity);
	}

	@Override
	public <T> List<T> find(BaseEntity baseEntity) {
		return this.getAbstractDaoHibernate().find(baseEntity);
	}

	@Override
	public <T> BaseEntity findById(Class<? extends BaseEntity> clazz, Integer id) {
		return this.getAbstractDaoHibernate().findById(clazz, id);
	}

	@Override
	public <T> List<T> findAll(Class<? extends BaseEntity> clazz) {
		return this.getAbstractDaoHibernate().findAll(clazz);
	}

	@Override
	public <T> BaseEntity findWithGet(Class<? extends BaseEntity> clazz, Integer id) {
		return this.getAbstractDaoHibernate().findWithGet(clazz, id);
	}

	@Override
	public <T> BaseEntity findWithLoad(Class<? extends BaseEntity> clazz, Integer id) {
		return this.getAbstractDaoHibernate().findWithLoad(clazz, id);
	}

	@Override
	public <T> List<T> findByQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros) {
		return this.getAbstractDaoHibernate().findByQuery(query, clazz, parametros);
	}

	@Override
	public <T> List<T> findBySQLQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros) {
		return this.getAbstractDaoHibernate().findBySQLQuery(query, clazz, parametros);
	}

	public AbstractDaoHibernate getAbstractDaoHibernate() {
		return abstractDaoHibernate;
	}

	public void setAbstractDaoHibernate(AbstractDaoHibernate abstractDaoHibernate) {
		this.abstractDaoHibernate = abstractDaoHibernate;
	}

}