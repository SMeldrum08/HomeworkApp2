package com.meldrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meldrum.dao.TeacherDao;
import com.meldrum.domain.TeacherEntity;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    /*
     * persist user to database
     * 
     * @param userEntity
     * 
     * @return true if a success
     */

    @Transactional
    public boolean createTeacher(TeacherEntity teacherEntity) {
	if (!teacherDao.checkAvailable(teacherEntity.getUserName())) {
	    // not available, needs error message

	    return false;
	}

	try {
	    teacherDao.save(teacherEntity);
	} catch (Exception e) {
	    // needs failed to save error message

	    return false;
	}
	return true;
    }
}
