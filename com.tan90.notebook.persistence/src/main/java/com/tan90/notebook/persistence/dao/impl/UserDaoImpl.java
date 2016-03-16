package com.tan90.notebook.persistence.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tan90.notebook.persistence.dao.UserDao;
import com.tan90.notebook.persistence.entities.User;

public class UserDaoImpl extends DaoImpl<User, Integer> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	
	public User getByUserName(String username) throws NoResultException {
		Query query = getEntityManager().createNamedQuery("User.findByUsername");
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}

	
	public User authenticate(String username, String password) throws NoResultException {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(
			criteriaBuilder.and(criteriaBuilder.equal(root.get("username"), username),
				criteriaBuilder.equal(root.get("password"), password)));
		TypedQuery<User> typedQuery = getEntityManager().createQuery(query);
		return typedQuery.getSingleResult();
	}
	
	

}
