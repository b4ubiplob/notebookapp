package com.tan90.notebook.service;

import java.util.List;

import com.tan90.notebook.to.EntryTO;

public interface EntryService {

	public List<EntryTO> getEntriesOfNotebook(int notebookId);
	
	public EntryTO createEntry(EntryTO entryTO);
	
	public boolean removeEntry(int id);
	
	public boolean updateEntry(EntryTO entryTO);
	
	
}
