package com.tan90.notebook.service;

import java.util.List;

import com.tan90.notebook.to.EntryTO;

public interface EntryService {

	
	public boolean createEntry(EntryTO entryTO);
	
	public boolean removeEntry(int id);
	
	public boolean updateEntry(EntryTO entryTO);

	public List<EntryTO> getEntriesOfUser(int userId);
	
	
}
