package com.tan90.notebook.to;

import java.util.Date;

public class EntryTO {

	private int id;
	private Date createdDate;
	private String description;
	private Date LastModified;
	private Date targetDate;
	private String title;
	private int notebookId;
	private int parentid;
	private int entryStatusId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastModified() {
		return LastModified;
	}

	public void setLastModified(Date lastModified) {
		LastModified = lastModified;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNotebookId() {
		return notebookId;
	}

	public void setNotebookId(int notebookId) {
		this.notebookId = notebookId;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getEntryStatusId() {
		return entryStatusId;
	}

	public void setEntryStatusId(int entryStatusId) {
		this.entryStatusId = entryStatusId;
	}

}
