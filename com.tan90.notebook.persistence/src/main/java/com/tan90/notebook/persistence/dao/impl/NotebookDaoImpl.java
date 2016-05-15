package com.tan90.notebook.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.tan90.notebook.persistence.DatabaseUtil;
import com.tan90.notebook.persistence.dao.NotebookDao;
import com.tan90.notebook.persistence.entities.Notebook;
import com.tan90.notebook.persistence.entities.User;

public class NotebookDaoImpl extends DaoImpl<Notebook, Integer> implements NotebookDao {

	public NotebookDaoImpl() {
		super(Notebook.class);
	}

	public List<Notebook> getNotebooksOfUser(User user) {
		Query query = DatabaseUtil.getEntityManager().createNamedQuery("Notebook.findByUser");
		query.setParameter("user", user);
		return query.getResultList();
	}
}
