package com.meldrum.dao;

import com.meldrum.commons.GenericDao;
import com.meldrum.domain.TeacherEntity;

/*
 * 
 * 
 */

public interface TeacherDao extends GenericDao<TeacherEntity, Long> {

    /*
     * Queries database for username availability
     */
    boolean checkAvailable(String userName);

    /*
     * Queries database to output user info
     */

    TeacherEntity loadUserByUsername(String userName);

}
