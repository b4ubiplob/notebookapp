package com.tan90.notebook.persistence.dao.impl;

import com.tan90.notebook.persistence.dao.EntryDao;
import com.tan90.notebook.persistence.entities.Entry;

public class EntryDaoImpl extends DaoImpl<Entry, Integer> implements EntryDao {

	public EntryDaoImpl() {
		super(Entry.class);
	}
}
