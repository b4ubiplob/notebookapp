package com.tan90.notebook.persistence.dao;

import com.tan90.notebook.persistence.entities.User;

public interface UserDao extends Dao<User, Integer> {

	public User getByUserName(String username);
	
	public User authenticate(String username, String password);
}
