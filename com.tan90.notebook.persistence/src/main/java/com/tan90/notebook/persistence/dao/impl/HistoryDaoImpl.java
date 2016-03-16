package com.tan90.notebook.persistence.dao.impl;

import com.tan90.notebook.persistence.dao.HistoryDao;
import com.tan90.notebook.persistence.entities.History;

public class HistoryDaoImpl extends DaoImpl<History, Integer> implements HistoryDao {

	public HistoryDaoImpl() {
		super(History.class);
	}
}
