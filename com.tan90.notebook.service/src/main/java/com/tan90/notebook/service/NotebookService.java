package com.tan90.notebook.service;

import java.util.List;

import com.tan90.notebook.to.EntryTO;
import com.tan90.notebook.to.NotebookTO;
import com.tan90.notebook.to.NotebookTypeTO;

public interface NotebookService {

	public NotebookTO createNotebook(NotebookTO notebookTO, int userId);
	
	public NotebookTO getNotebook(int id);
	
	public boolean removeNotebook(int id);
	
	public boolean updateNotebook(NotebookTO notebookTO);
	
	public List<NotebookTO> getNotebooksOfUser(int userId);

	public List<EntryTO> getEntriesOfNotebook(int notebookId);

	public List<NotebookTypeTO> getAllNotebookTypes();
	
	public List<NotebookTO> getAllNotebooks();
	
	

}
