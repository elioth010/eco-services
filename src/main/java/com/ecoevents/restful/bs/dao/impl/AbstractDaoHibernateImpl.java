package com.ecoevents.restful.bs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

import com.ecoevents.restful.bs.dao.AbstractDaoHibernate;
import com.ecoevents.restful.eis.bo.base.BaseEntity;
import com.ecoevents.restful.util.persistence.ListaParametrosDTO;
import com.ecoevents.restful.util.persistence.Parametro;

/**
 * @author developer
 */
public class AbstractDaoHibernateImpl implements AbstractDaoHibernate{

	protected SessionFactory session;
	private static final String FROM = "from";

	@Transactional
	@Override
	public <T> BaseEntity save(BaseEntity baseEntity) {
		this.getSession().save(baseEntity);
		return baseEntity;
	}

	@Transactional
	@Override
	public void update(BaseEntity baseEntity) {
		this.getSession().update(baseEntity);
	}

	@Transactional
	@Override
	public void delete(BaseEntity baseEntity) {
		this.getSession().delete(baseEntity);
	}

	@Transactional
	@Override
	public <T> BaseEntity findWithGet(Class<? extends BaseEntity> clazz, Integer id) {
		return (BaseEntity) this.getSession().get(clazz, id);
	}

	@Transactional
	@Override
	public <T> BaseEntity findWithLoad(Class<? extends BaseEntity> clazz, Integer id) {
		return (BaseEntity) this.getSession().load(clazz, id);
	}

	@Transactional
	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> List<T> findAll(Class<? extends BaseEntity> clazz) {
		return this.getSession().createQuery(FROM + " " + clazz.getName()).list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(BaseEntity baseEntity) {
		Criteria criteria = this.getSession().createCriteria(baseEntity.getClass());
		criteria.add(Example.create(baseEntity));
		return criteria.list();
	}

	public Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return session;
	}

	public void setSessionFactory(SessionFactory session) {
		this.session = session;
	}

	@Transactional
	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> List<T> findByQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros) {
		Query querySQL = this.getSession().getNamedQuery(query);
		List<Parametro> listParametros = parametros.getParametros();
		for (Parametro param : listParametros) {
			querySQL.setParameter(param.getName(), param.getValue());
		}
		return querySQL.list();
	}

	@Transactional
	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> List<T> findBySQLQuery(String query, Class<? extends BaseEntity> clazz, ListaParametrosDTO parametros) {
		Query querySQL = this.getSession().createSQLQuery(query);
		for (Parametro param : parametros.getParametros()) {
			querySQL.setParameter(param.getName(), param.getValue(), param.getType());
		}
		querySQL.setResultTransformer(Transformers.aliasToBean(clazz));
		return querySQL.list();
	}

	@Transactional
	@Override
	public <T> BaseEntity findById(Class<? extends BaseEntity> clazz, Integer id) {
		return findWithGet(clazz, id);
	}
}
