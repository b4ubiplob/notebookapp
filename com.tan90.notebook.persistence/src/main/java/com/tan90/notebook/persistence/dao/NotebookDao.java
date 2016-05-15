package com.tan90.notebook.persistence.dao;

import java.util.List;

import com.tan90.notebook.persistence.entities.Notebook;
import com.tan90.notebook.persistence.entities.User;

public interface NotebookDao extends Dao<Notebook, Integer> {

	public List<Notebook> getNotebooksOfUser(User user);
}
