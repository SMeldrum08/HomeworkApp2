package com.meldrum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meldrum.dao.TeacherDao;

@Service("teacherUserDetailsService")
public class TeacherUserDetailsService implements UserDetailsService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	return (UserDetails) teacherDao.loadUserByUsername(username);
    }

}
