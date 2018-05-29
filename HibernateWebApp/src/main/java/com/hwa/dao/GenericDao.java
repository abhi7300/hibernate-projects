package com.hwa.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E, PK extends Serializable> {

	PK save(E newInstance);

	/**
	 * Use this API to trigger the save query immediately This should be used
	 * for special case only
	 * 
	 * @param transientObject
	 */
	PK saveImmediately(E transientObject);

	void update(E transientObject);

	/**
	 * Use this API to trigger the update query immediately This should be used
	 * for special case only
	 * 
	 * @param transientObject
	 */
	void updateImmediately(E transientObject);

	void saveOrUpdate(E transientObject);

	void delete(E persistentObject);

	E findById(PK id);

	List<E> findAll();

	List<E> findAllByProperty(String propertyName, Object value);

	List<E> findAllByProperties(List<String> propertyNames, List<Object> values);

	int getCount();
}
