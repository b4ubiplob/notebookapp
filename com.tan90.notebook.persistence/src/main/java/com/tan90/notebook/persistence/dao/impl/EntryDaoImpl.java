package com.tan90.notebook.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tan90.notebook.persistence.DatabaseUtil;
import com.tan90.notebook.persistence.dao.EntryDao;
import com.tan90.notebook.persistence.entities.Entry;
import com.tan90.notebook.persistence.entities.Notebook;

public class EntryDaoImpl extends DaoImpl<Entry, Integer> implements EntryDao {

	public EntryDaoImpl() {
		super(Entry.class);
	}

	public List<Entry> getEntriesOfNotebooks(List<Notebook> notebooks) {
		EntityManager entityManager = DatabaseUtil.getEntityManager();
		Query query = entityManager.createNamedQuery("Entry.findByNotebooks");
		query.setParameter("notebookList", notebooks);
		return query.getResultList();
	}

	
}
