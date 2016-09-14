package com.meldrum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.meldrum.commons.BaseEntity;

/*
 * 
 * This entity is to hold the rolls of all types of account
 * 
 * 
 */
@Entity
@Table(name = "teacheraccount")
public class UserRolesEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 9014169812363387062L;
    private String username;
    private String role;

    public String getUsername() {
	return username;
    }

    @ManyToMany(mappedBy = "username", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    public void setUsername(String username) {
	this.username = username;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }
}
