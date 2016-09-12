package com.meldrum.commons;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * This is the base class for Id to be extended
 * 
 * 
 */

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -3295791455386550639L;
	
	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}