package com.meldrum.dao;

import com.meldrum.commons.GenericDao;
import com.meldrum.domain.UserRolesEntity;

public interface UserRolesDao extends GenericDao<UserRolesEntity, Long> {

    UserRolesEntity loadUserByUsername(String userName);

}