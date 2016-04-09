package com.tan90.notebook.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tan90.notebook.persistence.entities.Entry;
import com.tan90.notebook.service.EntryService;
import com.tan90.notebook.to.EntryTO;

public class EntryServiceImpl implements EntryService {

	public List<EntryTO> getEntriesOfNotebook(int notebookId) {
		
		return null;
	}

	public EntryTO createEntry(EntryTO entryTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeEntry(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateEntry(EntryTO entryTO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private EntryTO getEntryTO(Entry entry) {
		EntryTO entryTO = new EntryTO();
		entryTO.setCreatedDate(new Date(entry.getCreatedTime().getTime()));
		entryTO.setDescription(entry.getDescription());
		entryTO.setId(entry.getId());
		entryTO.setLastModified(new Date(entry.getLastModified().getTime()));
		entryTO.setNotebookId(entry.getNotebook().getId());
		entryTO.setParentid(entry.getEntry().getId());
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
}
