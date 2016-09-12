package com.meldrum.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.meldrum.commons.BaseEntity;

/*
 * 
 * This entity is to hold application user data
 * 
 * 
 */
@Entity
@Table(name = "teacheraccount")
public class TeacherEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 9014169812363387062L;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int schoolid = 4;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	this.password = passwordEncoder.encode(password);
    }

    public int getSchoolid() {
	return schoolid;
    }

    public void setSchoolid(int schoolid) {
	this.schoolid = 5;
    }

}