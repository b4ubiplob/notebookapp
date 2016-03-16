package com.tan90.notebook.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tan90.notebook.persistence.DatabaseUtil;
import com.tan90.notebook.persistence.dao.impl.UserDaoImpl;
import com.tan90.notebook.persistence.entities.User;

public class UserDaoTest {
	
	private static UserDao userDao;
	
	@BeforeClass
	public static void init() {
		System.out.println("init................................................");
		userDao = new UserDaoImpl();
	}

	@Test
	public void testGetAll() {
		List<User> users = userDao.findAll();
		assertTrue(users.size() > 0);
	}

	@Test
	public void testGetById() {
		User createdUser = createUser("user_test_id", "user_test_id");
		User user = userDao.find(createdUser.getId());
		assertEquals(user.getId(), createdUser.getId());
	}

	@Test
	public void testSave() {
		User user = createUser("admin", "admin");
		assertNotEquals(0, user.getId());
	}
	
	private User createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User newUser = userDao.save(user);
		return newUser;
	}
	
	@Test
	public void testGetByUserName() {
		createUser("admin123", "admin123");
		User newUser = userDao.getByUserName("admin123");
		assertEquals("admin123", newUser.getUsername());
	}

	@Test
	public void testRemove() {
		createUser("user_remove", "user_remove");
		User user = userDao.getByUserName("user_remove");
		assertTrue(userDao.remove(user.getId()));
	}

	@AfterClass
	public static void cleanup() {
		System.out.println("cleanup................................................");
		User user = userDao.getByUserName("admin123");
		userDao.remove(user.getId());
		user = userDao.getByUserName("admin");
		userDao.remove(user.getId());
		user = userDao.getByUserName("user_test_id");
		userDao.remove(user.getId());
	}
}
