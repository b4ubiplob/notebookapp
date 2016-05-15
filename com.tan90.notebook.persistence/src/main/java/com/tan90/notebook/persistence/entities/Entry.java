package com.tan90.notebook.persistence.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the entry database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e"),
	@NamedQuery(name="Entry.findByNotebooks", query="SELECT e FROM Entry e WHERE e.notebook IN :notebookList")
})
public class Entry implements DbEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp createdTime;

	@Type(type="text")
	private String description;

	private Timestamp lastModified;

	@Temporal(TemporalType.DATE)
	private Date targetDate;

	private String titile;

	//bi-directional many-to-one association to Notebook
	@ManyToOne
	private Notebook notebook;

	//bi-directional many-to-one association to Entry
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Entry parent;

	//bi-directional many-to-one association to Entry
	@OneToMany(mappedBy="parent")
	private List<Entry> entries;

	//bi-directional many-to-one association to TaskStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private EntryStatus entryStatus;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="entry")
	private List<History> histories;

	public Entry() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public Date getTargetDate() {
		return this.targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getTitile() {
		return this.titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public Notebook getNotebook() {
		return this.notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public Entry getParent() {
		return this.parent;
	}

	public void setParent(Entry parent) {
		this.parent = parent;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public Entry addEntry(Entry entry) {
		getEntries().add(entry);
		entry.setParent(this);

		return entry;
	}

	public Entry removeEntry(Entry entry) {
		getEntries().remove(entry);
		entry.setParent(null);

		return entry;
	}

	public EntryStatus getEntryStatus() {
		return this.entryStatus;
	}

	public void setEntryStatus(EntryStatus entryStatus) {
		this.entryStatus = entryStatus;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setEntry(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setEntry(null);

		return history;
	}

}