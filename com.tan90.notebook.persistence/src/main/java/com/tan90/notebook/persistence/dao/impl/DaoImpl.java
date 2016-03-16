package com.tan90.notebook.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.tan90.notebook.persistence.DatabaseUtil;
import com.tan90.notebook.persistence.dao.Dao;
import com.tan90.notebook.persistence.entities.DbEntity;

public class DaoImpl<T extends DbEntity, I> implements Dao<T, I>{

	private Class<T> entityClass;
	private EntityManager entityManager;
	
	public DaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		entityManager = DatabaseUtil.getEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	
	public List<T> findAll() {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
		criteriaQuery.from(this.entityClass);
		TypedQuery<T> typedQuery = this.entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	
	public T find(I i) {
		return this.entityManager.find(entityClass, i);
	}

	
	public T save(T t) {
		DatabaseUtil.startTransaction();
		T savedT = this.entityManager.merge(t);
		DatabaseUtil.commitTransaction();
		return savedT;
	}

	
	public boolean remove(I id) {
		if (id == null) {
			return false;
		}
		T entity = find(id);
		if (entity == null) {
			return false;
		}
		DatabaseUtil.startTransaction();
		this.entityManager.remove(entity);
		DatabaseUtil.commitTransaction();
		return true;
	}

}
