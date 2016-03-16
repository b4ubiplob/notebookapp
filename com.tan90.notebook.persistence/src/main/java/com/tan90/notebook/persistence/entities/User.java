package com.tan90.notebook.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
@NamedQuery(name="User.findByUsername", query="SELECT u FROM User u where u.username = :username")
})
public class User implements DbEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String password;

	private String username;

	//bi-directional many-to-one association to Notebook
	@OneToMany(mappedBy="user")
	private List<Notebook> notebooks;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Notebook> getNotebooks() {
		return this.notebooks;
	}

	public void setNotebooks(List<Notebook> notebooks) {
		this.notebooks = notebooks;
	}

	public Notebook addNotebook(Notebook notebook) {
		getNotebooks().add(notebook);
		notebook.setUser(this);

		return notebook;
	}

	public Notebook removeNotebook(Notebook notebook) {
		getNotebooks().remove(notebook);
		notebook.setUser(null);

		return notebook;
	}

}