package com.tan90.notebook.to;

import java.util.List;

public class NotebookTO {

	private int id;
	private String name;
	private int userId;
	private List<EntryTO> entries;
	private int notebookTypeId;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<EntryTO> getEntries() {
		return entries;
	}

	public void setEntries(List<EntryTO> entries) {
		this.entries = entries;
	}

	public int getNotebookTypeId() {
		return notebookTypeId;
	}

	public void setNotebookTypeId(int notebookTypeId) {
		this.notebookTypeId = notebookTypeId;
	}

}
