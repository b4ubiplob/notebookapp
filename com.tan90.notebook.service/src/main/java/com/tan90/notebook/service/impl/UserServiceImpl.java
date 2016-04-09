package com.tan90.notebook.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tan90.notebook.persistence.dao.UserDao;
import com.tan90.notebook.persistence.dao.impl.UserDaoImpl;
import com.tan90.notebook.persistence.entities.User;
import com.tan90.notebook.service.UserService;
import com.tan90.notebook.to.LoginTO;
import com.tan90.notebook.to.UserTO;
import com.tan90.notebook.util.PasswordHasher;

public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	public UserTO authenticate(LoginTO loginTo) {
		String password;
		try {
			password = PasswordHasher.hash(loginTo.getPassword());
			return getUserProfileTO(userDao.authenticate(loginTo.getUsername(), password));
		} catch (NoSuchAlgorithmException e) {
			logger.error("No such hashing algorithm");
		} 
		catch (NoResultException e) {
			logger.error("No user found with this username and password");
		}
		return null;
	}

	public List<UserTO> getAllUsers() {
		List<User> users = userDao.findAll();
		List<UserTO> userProfiles = new ArrayList<UserTO>();
		for (User user : users) {
			userProfiles.add(getUserProfileTO(user));
		}
		return userProfiles;
	}

	public UserTO getUser(int id) {
		return getUserProfileTO(userDao.find(id));
	}

	public UserTO createUser(UserTO userTO) {
		try {
			User user = getUser(userTO, false);
			return getUserProfileTO(userDao.save(user));
		} catch (NoSuchAlgorithmException e) {
			logger.error("No such hashing algorithm");
		}
		return null;
	}
	
	private UserTO getUserProfileTO(User user) {
		UserTO userProfileTO = new UserTO();
		userProfileTO.setUsername(user.getUsername());
		userProfileTO.setId(user.getId());
		return userProfileTO;
	}
	
	private User getUser(UserTO userTO, boolean isUpdate) throws NoSuchAlgorithmException {
		User user = null;
		if (isUpdate) {
			user = userDao.find(userTO.getId());
		}
		else {
			user = new User();
		}
		user.setUsername(userTO.getUsername());
		user.setPassword(PasswordHasher.hash(userTO.getPassword()));
		return user;
	}

	public boolean deleteUser(int id) {
		return userDao.remove(id);
	}

	public boolean updateUser(UserTO userTO) {
		User user = userDao.find(userTO.getId());
		try {
			user = getUser(userTO, true);
			if (userDao.save(user) != null) {
				return true;
			}
		}
		catch (NoSuchAlgorithmException e) {
			logger.error("No such hashing algorithm");
		}
		return false;
	}

}
