package com.tan90.notebook.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the entry_status database table.
 * 
 */
@Entity
@Table(name="entry_status")
@NamedQuery(name="EntryStatus.findAll", query="SELECT t FROM EntryStatus t")
public class EntryStatus implements DbEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String status;

	//bi-directional many-to-one association to Entry
	@OneToMany(mappedBy="entryStatus")
	private List<Entry> entries;

	public EntryStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public Entry addEntry(Entry entry) {
		getEntries().add(entry);
		entry.setEntryStatus(this);

		return entry;
	}

	public Entry removeEntry(Entry entry) {
		getEntries().remove(entry);
		entry.setEntryStatus(null);

		return entry;
	}

}