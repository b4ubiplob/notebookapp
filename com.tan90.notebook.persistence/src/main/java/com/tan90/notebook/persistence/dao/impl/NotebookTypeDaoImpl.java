package com.tan90.notebook.persistence.dao.impl;

import com.tan90.notebook.persistence.dao.NoteBookTypeDao;
import com.tan90.notebook.persistence.entities.NotebookType;

public class NotebookTypeDaoImpl extends DaoImpl<NotebookType, Integer> implements NoteBookTypeDao {

	public NotebookTypeDaoImpl() {
		super(NotebookType.class);
	}

}
