package com.tan90.notebook.persistence.dao.impl;

import com.tan90.notebook.persistence.dao.EntryStatusDao;
import com.tan90.notebook.persistence.entities.EntryStatus;

public class EntryStatusDaoImpl extends DaoImpl<EntryStatus, Integer> implements EntryStatusDao {
	
	public EntryStatusDaoImpl() {
		super(EntryStatus.class);
	}

}
