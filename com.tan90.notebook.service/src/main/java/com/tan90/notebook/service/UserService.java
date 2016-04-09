package com.tan90.notebook.service;

import java.util.List;

import com.tan90.notebook.to.LoginTO;
import com.tan90.notebook.to.UserTO;

public interface UserService {

	public UserTO authenticate(LoginTO loginTo);
	
	public List<UserTO> getAllUsers();
	
	public UserTO getUser(int id);
	
	public UserTO createUser(UserTO userTO);
	
	public boolean deleteUser(int id);
	
	public boolean updateUser(UserTO userTO);
	
}
