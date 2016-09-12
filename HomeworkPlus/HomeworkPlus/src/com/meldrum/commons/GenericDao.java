package com.meldrum.commons;


import java.io.Serializable;
import java.util.List;

/*
 * This is the generic interface for Data Access Objects, to be extended or implemented
 * I should probably read up more on this stuff
 * 
 * 
 * 
 */
public interface GenericDao<T, ID extends Serializable>  {
	
	T save(T entity);
	T update(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();
	void flush();
	

}
