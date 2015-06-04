package com.ecoevents.restful.bs.service.hibernate;

import java.util.List;

import com.ecoevents.restful.eis.bo.base.BaseEntity;
import com.ecoevents.restful.util.persistence.ListaParametrosDTO;

public interface AbstractServiceHibernate {
	public <T> BaseEntity save(BaseEntity baseEntity);

	public void update(BaseEntity baseEntity);

	public void delete(BaseEntity baseEntity);

	public <T> List<T> find(BaseEntity baseEntity);

	public <T>BaseEntity findById(Class<? extends BaseEntity> clazz, Integer id);

	public <T> List<T> findAll(Class<? extends BaseEntity> clazz);
	
	public <T>BaseEntity findWithGet(Class<? extends BaseEntity> clazz, Integer id);
	
	public <T>BaseEntity findWithLoad(Class<? extends BaseEntity> clazz, Integer id);
	
	public <T> List<T> findByQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros);

	public <T> List<T> findBySQLQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros);
}
