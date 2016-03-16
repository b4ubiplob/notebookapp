package com.tan90.notebook.persistence.dao;

import java.util.List;

import com.tan90.notebook.persistence.entities.DbEntity;

public interface Dao<T extends DbEntity, I> {

	public List<T> findAll();
	
	public T find(I i);
	
	public T save(T t);
	
	public boolean remove(I i);
}
