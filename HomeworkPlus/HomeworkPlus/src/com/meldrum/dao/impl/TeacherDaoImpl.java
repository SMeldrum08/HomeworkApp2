package com.meldrum.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.meldrum.commons.GenericJpaDao;
import com.meldrum.dao.TeacherDao;
import com.meldrum.domain.TeacherEntity;

/*
 * Data access object to work with user database operations
 */

@Repository
public class TeacherDaoImpl extends GenericJpaDao<TeacherEntity, Long> implements TeacherDao {

    public TeacherDaoImpl() {
	super(TeacherEntity.class);
    }

    @Override
    @Transactional
    public boolean checkAvailable(String userName) {
	Assert.notNull(userName);

	Query query = getEntityManager().createQuery(
		"select count(*) from " + getPersistentClass().getSimpleName() + " u where u.userName = :userName")
		.setParameter("userName", userName);
	Long count = (Long) query.getSingleResult();

	return count < 1;
    }

    @Override
    @Transactional
    public TeacherEntity loadUserByUsername(String userName) {

	Assert.notNull(userName);

	TeacherEntity user = null;

	Query query = getEntityManager()
		.createQuery(
			"select u from " + getPersistentClass().getSimpleName() + " u where u.userName = :userName")
		.setParameter("userName", userName);

	try {
	    user = (TeacherEntity) query.getSingleResult();
	} catch (NoResultException e) {
	    // Do nothing
	}

	return user;
    }

}