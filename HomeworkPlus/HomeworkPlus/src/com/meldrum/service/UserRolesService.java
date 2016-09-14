package com.meldrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meldrum.dao.UserRolesDao;
import com.meldrum.domain.UserRolesEntity;

@Service
public class UserRolesService {

    @Autowired
    private UserRolesDao userRolesDao;

    /*
     * persist user to database
     * 
     * @param userEntity
     * 
     * @return true if a success
     */

    @Transactional
    public boolean createUserRole(String username, String userRole) {

	UserRolesEntity userRolesEntity = new UserRolesEntity();
	userRolesEntity.setUsername(username);
	userRolesEntity.setRole(userRole);

	// there is no check if the username is unique as I am unsure if I want
	// that to be the case in this table

	try {
	    userRolesDao.save(userRolesEntity);
	} catch (Exception e) {
	    // needs failed to save error message

	    return false;
	}
	return true;
    }

}