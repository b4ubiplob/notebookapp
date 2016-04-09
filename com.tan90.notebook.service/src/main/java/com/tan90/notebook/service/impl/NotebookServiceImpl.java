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
import com.tan90.notebook.persistence.entities.Notebook;
import com.tan90.notebook.persistence.entities.User;
import com.tan90.notebook.service.NotebookService;
import com.tan90.notebook.to.NotebookTO;

public class NotebookServiceImpl implements NotebookService {

	private UserDao userDao;
	private NotebookDao notebookDao;
	private NoteBookTypeDao noteBookTypeDao;
	
	public NotebookServiceImpl() {
		notebookDao = new NotebookDaoImpl();
		userDao = new UserDaoImpl();
		noteBookTypeDao = new NotebookTypeDaoImpl();
	}
	
	public NotebookTO createNotebook(NotebookTO notebookTO) {
		Notebook notebook = getNotebook(notebookTO,false);
		return getNotebookTO(notebookDao.save(notebook));
	}
	
	private NotebookTO getNotebookTO(Notebook notebook) {
		NotebookTO notebookTO = new NotebookTO();
		notebookTO.setId(notebook.getId());
		notebookTO.setName(notebook.getName());
		notebookTO.setNotebookTypeId(notebook.getNotebookType().getId());
		notebookTO.setUserId(notebook.getUser().getId());
		notebookTO.setEntries(new EntryServiceImpl().getEntryTOsOfNotebook(notebook.getEntries()));
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
		for (Notebook notebook : user.getNotebooks()) {
			notebookTOs.add(getNotebookTO(notebook));
		}
		return notebookTOs;
	}

}
