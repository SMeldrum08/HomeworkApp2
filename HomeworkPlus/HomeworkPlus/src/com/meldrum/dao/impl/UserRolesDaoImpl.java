package com.meldrum.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.meldrum.commons.GenericJpaDao;
import com.meldrum.dao.UserRolesDao;
import com.meldrum.domain.UserRolesEntity;

@Repository
public class UserRolesDaoImpl extends GenericJpaDao<UserRolesEntity, Long> implements UserRolesDao {

    public UserRolesDaoImpl() {
	super(UserRolesEntity.class);
    }

    @Override
    @Transactional
    public UserRolesEntity loadUserByUsername(String username) {

	Assert.notNull(username);

	UserRolesEntity user = null;

	Query query = getEntityManager()
		.createQuery(
			"select u from " + getPersistentClass().getSimpleName() + " u where u.userName = :userName")
		.setParameter("userName", username);

	try {
	    user = (UserRolesEntity) query.getSingleResult();
	} catch (NoResultException e) {
	    // Do nothing
	}

	return user;
    }

}