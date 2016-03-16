package com.tan90.notebook.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the notebook_type database table.
 * 
 */
@Entity
@Table(name="notebook_type")
@NamedQuery(name="NotebookType.findAll", query="SELECT n FROM NotebookType n")
public class NotebookType implements DbEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="type_name")
	private String typeName;

	//bi-directional many-to-one association to Notebook
	@OneToMany(mappedBy="notebookType")
	private List<Notebook> notebooks;

	public NotebookType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Notebook> getNotebooks() {
		return this.notebooks;
	}

	public void setNotebooks(List<Notebook> notebooks) {
		this.notebooks = notebooks;
	}

	public Notebook addNotebook(Notebook notebook) {
		getNotebooks().add(notebook);
		notebook.setNotebookType(this);

		return notebook;
	}

	public Notebook removeNotebook(Notebook notebook) {
		getNotebooks().remove(notebook);
		notebook.setNotebookType(null);

		return notebook;
	}

}