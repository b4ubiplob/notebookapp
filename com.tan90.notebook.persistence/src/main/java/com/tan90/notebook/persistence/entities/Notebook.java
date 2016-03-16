package com.tan90.notebook.persistence.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the notebook database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Notebook.findAll", query="SELECT n FROM Notebook n"),
@NamedQuery(name="Notebook.findByUser", query="SELECT n FROM Notebook n where n.user = :user")
})
public class Notebook implements DbEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String name;

	//bi-directional many-to-one association to Entry
	@OneToMany(mappedBy="notebook")
	private List<Entry> entries;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to NotebookType
	@ManyToOne
	@JoinColumn(name="notebook_type_id")
	private NotebookType notebookType;

	public Notebook() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public Entry addEntry(Entry entry) {
		getEntries().add(entry);
		entry.setNotebook(this);

		return entry;
	}

	public Entry removeEntry(Entry entry) {
		getEntries().remove(entry);
		entry.setNotebook(null);

		return entry;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NotebookType getNotebookType() {
		return this.notebookType;
	}

	public void setNotebookType(NotebookType notebookType) {
		this.notebookType = notebookType;
	}

}