package com.tan90.notebook.persistence.dao.impl;

import com.tan90.notebook.persistence.dao.NotebookDao;
import com.tan90.notebook.persistence.entities.Notebook;

public class NotebookDaoImpl extends DaoImpl<Notebook, Integer> implements NotebookDao {

	public NotebookDaoImpl() {
		super(Notebook.class);
	}
}
