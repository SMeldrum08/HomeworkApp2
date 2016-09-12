package com.meldrum.commons;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/*
 * 
 * provides generic common implementation of GenericDao 
 * is an abstract class
 * copy and pasted from git so possible errors
 * 
 */

@Transactional
public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    private Class<T> persistentClass;

    private EntityManager entityManager;

    public GenericJpaDao(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
    }

    protected EntityManager getEntityManager() {
	return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public Class<T> getPersistentClass() {
	return persistentClass;
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
	T entity = getEntityManager().find(getPersistentClass(), id);
	return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findAll() {
	return getEntityManager().createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
		.getResultList();
    }

    @Override
    @Transactional
    public T save(T entity) {
	getEntityManager().persist(entity);
	return entity;
    }

    @Override
    public T update(T entity) {
	T mergedEntity = getEntityManager().merge(entity);
	return mergedEntity;
    }

    @Override
    public void delete(T entity) {
	if (BaseEntity.class.isAssignableFrom(persistentClass)) {
	    getEntityManager()
		    .remove(getEntityManager().getReference(entity.getClass(), ((BaseEntity) entity).getId()));
	} else {
	    entity = getEntityManager().merge(entity);
	    getEntityManager().remove(entity);
	}
    }

    @Override
    public void flush() {
	getEntityManager().flush();
    }

}
