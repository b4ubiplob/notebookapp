package com.tan90.notebook.service;

import java.util.List;

import com.tan90.notebook.to.NotebookTO;

public interface NotebookService {

	public NotebookTO createNotebook(NotebookTO notebookTO);
	
	public boolean removeNotebook(int id);
	
	public boolean updateNotebook(NotebookTO notebookTO);
	
	public List<NotebookTO> getNotebooksOfUser(int userId);

}
