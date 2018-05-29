package com.hwa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.hwa.dao.GenericDao;

public abstract class GenericDaoImpl<E, PK extends Serializable> implements GenericDao<E, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	public PK save(E newInstance) {
		return (PK) sessionFactory.getCurrentSession().save(newInstance);
	}

	public PK saveImmediately(E newInstance) {
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
		PK pk = (PK) getSessionFactory().getCurrentSession().save(newInstance);
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return pk;
	}

	public void update(E transientObject) {
		getSessionFactory().getCurrentSession().update(transientObject);

	}

	public void updateImmediately(E transientObject) {
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
		getSessionFactory().getCurrentSession().update(transientObject);
		getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);

	}

	public void saveOrUpdate(E transientObject) {
		getSessionFactory().getCurrentSession().saveOrUpdate(transientObject);

	}

	public void delete(E persistentObject) {
		getSessionFactory().getCurrentSession().delete(persistentObject);

	}

	public E findById(PK id) {
		return (E) getSessionFactory().getCurrentSession().get(getEntityClass(), id);
	}

	protected abstract Class<E> getEntityClass();

	public List<E> findAll() {
		// return (List<E>)
		// getSessionFactory().getCurrentSession().findByCriteria(createDetachedCriteria());
		return createDetachedCriteria().getExecutableCriteria(getSessionFactory().getCurrentSession()).list();

	}

	public List<E> findAllByProperty(String propertyName, Object value) {
		DetachedCriteria criteria = createDetachedCriteria();
		criteria.add(Restrictions.eq(propertyName, value));
		// return (List<E>)
		// getSessionFactory().getCurrentSession().findByCriteria(criteria);
		return createDetachedCriteria().getExecutableCriteria(getSessionFactory().getCurrentSession()).list();
	}

	public List<E> findAllByProperties(List<String> propertyNames, List<Object> values) {
		DetachedCriteria criteria = createDetachedCriteria();
		int count = 0;
		for (String propertyName : propertyNames) {
			criteria.add(Restrictions.eq(propertyName, values.get(count)));
			count++;
		}

		return createDetachedCriteria().getExecutableCriteria(getSessionFactory().getCurrentSession()).list();
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected DetachedCriteria createDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(getEntityClass());
		return detachedCriteria;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
