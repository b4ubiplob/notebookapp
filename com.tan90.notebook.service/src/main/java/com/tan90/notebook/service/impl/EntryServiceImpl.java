package com.tan90.notebook.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tan90.notebook.persistence.dao.EntryDao;
import com.tan90.notebook.persistence.dao.EntryStatusDao;
import com.tan90.notebook.persistence.dao.NotebookDao;
import com.tan90.notebook.persistence.dao.UserDao;
import com.tan90.notebook.persistence.dao.impl.EntryDaoImpl;
import com.tan90.notebook.persistence.dao.impl.EntryStatusDaoImpl;
import com.tan90.notebook.persistence.dao.impl.NotebookDaoImpl;
import com.tan90.notebook.persistence.dao.impl.UserDaoImpl;
import com.tan90.notebook.persistence.entities.Entry;
import com.tan90.notebook.persistence.entities.User;
import com.tan90.notebook.service.EntryService;
import com.tan90.notebook.to.EntryTO;

public class EntryServiceImpl implements EntryService {
	
	private NotebookDao notebookDao = new NotebookDaoImpl();
	private EntryDao entryDao = new EntryDaoImpl();
	private EntryStatusDao entryStatusDao = new EntryStatusDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	public boolean createEntry(EntryTO entryTO) {
		if (null != entryDao.save(getEntry(entryTO, new Entry()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private Entry getEntry(EntryTO entryTO, Entry entry) {
		entry.setCreatedTime(new Timestamp(new Date().getTime()));
		entry.setDescription(entryTO.getDescription());
		entry.setNotebook(notebookDao.find(entryTO.getNotebookId()));
		entry.setParent(entryDao.find(entryTO.getParentid()));
		entry.setEntryStatus(entryStatusDao.find(entryTO.getEntryStatusId()));
		entry.setTitile(entryTO.getTitle());
		entry.setTargetDate(entryTO.getTargetDate());
		entry.setLastModified(new Timestamp(new Date().getTime()));
		return entry;
	}


	public boolean removeEntry(int id) {
		return entryDao.remove(id);
	}

	public boolean updateEntry(EntryTO entryTO) {
		Entry entry = entryDao.find(entryTO.getId());
		if (entry == null) {
			return false;
		}
		return (null != entryDao.save(getEntry(entryTO, entry)));
	}
	
	private EntryTO getEntryTO(Entry entry) {
		EntryTO entryTO = new EntryTO();
		entryTO.setCreatedDate(new Date(entry.getCreatedTime().getTime()));
		entryTO.setDescription(entry.getDescription());
		entryTO.setId(entry.getId());
		entryTO.setLastModified(new Date(entry.getLastModified().getTime()));
		entryTO.setNotebookId(entry.getNotebook().getId());
		Entry parent = entry.getParent();
		if (null == parent) {
			entryTO.setParentid(0);
		}
		else {
			entryTO.setParentid(parent.getId());
		}
		entryTO.setTargetDate(entry.getTargetDate());
		entryTO.setTitle(entry.getTitile());
		return entryTO;
	}

	public List<EntryTO> getEntryTOsOfNotebook(List<Entry> entries) {
		List<EntryTO> entryTOs = new ArrayList<EntryTO>();
		for (Entry entry : entries) {
			entryTOs.add(getEntryTO(entry));
		}
		return entryTOs;
	}

	public List<EntryTO> getEntriesOfUser(int userId) {
		User user = userDao.find(userId);
		return getEntryTOsOfNotebook(entryDao.getEntriesOfNotebooks(user.getNotebooks()));
	}
}
