package com.tan90.notebook.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tan90.notebook.persistence.dao.NoteBookTypeDao;
import com.tan90.notebook.persistence.dao.NotebookDao;
import com.tan90.notebook.persistence.dao.UserDao;
import com.tan90.notebook.persistence.dao.impl.NotebookDaoImpl;
import com.tan90.notebook.persistence.dao.impl.NotebookTypeDaoImpl;
import com.tan90.notebook.persistence.dao.impl.UserDaoImpl;
import com.tan90.notebook.persistence.entities.Entry;
import com.tan90.notebook.persistence.entities.Notebook;
import com.tan90.notebook.persistence.entities.NotebookType;
import com.tan90.notebook.persistence.entities.User;
import com.tan90.notebook.service.NotebookService;
import com.tan90.notebook.to.EntryTO;
import com.tan90.notebook.to.NotebookTO;
import com.tan90.notebook.to.NotebookTypeTO;

public class NotebookServiceImpl implements NotebookService {

	private UserDao userDao;
	private NotebookDao notebookDao;
	private NoteBookTypeDao noteBookTypeDao;
	
	public NotebookServiceImpl() {
		notebookDao = new NotebookDaoImpl();
		userDao = new UserDaoImpl();
		noteBookTypeDao = new NotebookTypeDaoImpl();
	}
	
	public NotebookTO createNotebook(NotebookTO notebookTO, int userId) {
		User user = userDao.find(userId);
		if (user == null) {
			//TODO throw exception
			return null;
		}
		Notebook notebook = getNotebook(notebookTO,false);
		notebook.setUser(user);
		return getNotebookTO(notebookDao.save(notebook));
	}
	
	private NotebookTO getNotebookTO(Notebook notebook) {
		NotebookTO notebookTO = new NotebookTO();
		notebookTO.setId(notebook.getId());
		notebookTO.setName(notebook.getName());
		notebookTO.setNotebookTypeId(notebook.getNotebookType().getId());
		notebookTO.setUserId(notebook.getUser().getId());
		List<Entry> entries = notebook.getEntries();
		if (null != entries && !entries.isEmpty()) {
			notebookTO.setEntries(new EntryServiceImpl().getEntryTOsOfNotebook(notebook.getEntries()));
		}
		return notebookTO;
	}
	
	private Notebook getNotebook(NotebookTO notebookTO, boolean isUpdate) {
		Notebook notebook =  null;
		if (isUpdate) {
			notebook = notebookDao.find(notebookTO.getId());
		}
		else {
			notebook = new Notebook();
		}
		notebook.setCreatedTime(new Timestamp(new Date().getTime()));
		notebook.setName(notebookTO.getName());
		notebook.setUser(userDao.find(notebookTO.getUserId()));
		notebook.setNotebookType(noteBookTypeDao.find(notebookTO.getNotebookTypeId()));
		return notebook;
	}

	public boolean removeNotebook(int id) {
		return notebookDao.remove(id);
	}

	public boolean updateNotebook(NotebookTO notebookTO) {
		return (notebookDao.save(getNotebook(notebookTO, true)) != null);
	}

	public List<NotebookTO> getNotebooksOfUser(int userId) {
		User user = userDao.find(userId);
		List<NotebookTO> notebookTOs = new ArrayList<NotebookTO>();
		for (Notebook notebook : notebookDao.getNotebooksOfUser(user)) {
			notebookTOs.add(getNotebookTO(notebook));
		}
		return notebookTOs;
	}
	
	public List<NotebookTO> getAllNotebooks() {
		List<NotebookTO> notebookTOs = new ArrayList<NotebookTO>();
		for (Notebook notebook : notebookDao.findAll()) {
			notebookTOs.add(getNotebookTO(notebook));
		}
		return notebookTOs;
	}

	public NotebookTO getNotebook(int id) {
		return getNotebookTO(notebookDao.find(id));
	}

	public List<EntryTO> getEntriesOfNotebook(int notebookId) {
		NotebookTO notebook = getNotebook(notebookId);
		if (null != notebook) {
			return notebook.getEntries();
		}
		return new ArrayList<EntryTO>();
	}
	
	public List<NotebookTypeTO> getNotebookTypeTos(List<NotebookType> notebookTypes) {
		List<NotebookTypeTO> notebookTypeTOs = new ArrayList<NotebookTypeTO>();
		for (NotebookType notebookType : notebookTypes) {
			NotebookTypeTO notebookTypeTO = new NotebookTypeTO();
			notebookTypeTO.setId(notebookType.getId());
			notebookTypeTO.setTypeName(notebookType.getTypeName());
			notebookTypeTOs.add(notebookTypeTO);
		}
		return notebookTypeTOs;
	}

	public List<NotebookTypeTO> getAllNotebookTypes() {
		return getNotebookTypeTos(noteBookTypeDao.findAll());
	
	}

}
