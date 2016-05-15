package com.tan90.notebook.persistence.dao;

import java.util.List;

import com.tan90.notebook.persistence.entities.Entry;
import com.tan90.notebook.persistence.entities.Notebook;

public interface EntryDao extends Dao<Entry, Integer>{
	
	public List<Entry> getEntriesOfNotebooks(List<Notebook> notebooks);
}
