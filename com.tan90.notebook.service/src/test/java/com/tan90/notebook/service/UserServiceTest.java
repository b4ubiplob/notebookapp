package com.tan90.notebook.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.tan90.notebook.service.impl.UserServiceImpl;
import com.tan90.notebook.to.LoginTO;
import com.tan90.notebook.to.UserTO;

public class UserServiceTest {

	private static UserService userService;
	
	@BeforeClass
	public static void initialize() {
		userService = new UserServiceImpl();
	}
	@Test @Ignore
	public void testAuthenticate() {
		UserTO userTO = createNewUser();
		assertNotNull(userTO);
		LoginTO loginTo = new LoginTO();
		loginTo.setUsername("admin123");
		loginTo.setPassword("admin123");
		UserTO authenticatedUser = userService.authenticate(loginTo);
		assertNotNull(authenticatedUser);
		deleteUser(authenticatedUser.getId());
	}
	
	@Test @Ignore
	public void testAuthenticateNegative() {
		UserTO userTO = createNewUser();
		assertNotNull(userTO);
		LoginTO loginTo = new LoginTO();
		loginTo.setUsername("admin123");
		loginTo.setPassword("admin1234");
		UserTO authenticatedUser = userService.authenticate(loginTo);
		assertNull(authenticatedUser);
		deleteUser(userTO.getId());
	}

	@Test @Ignore
	public void testGetAllUsers() {
		UserTO userTO = createNewUser();
		List<UserTO> users = userService.getAllUsers();
		assertTrue(users.size() > 0);
		userService.deleteUser(userTO.getId());
	}

	@Test @Ignore
	public void testGetUser() {
		UserTO userTO = createNewUser();
		UserTO newUser = userService.getUser(userTO.getId());
		assertEquals("admin", newUser.getUsername());
		userService.deleteUser(userTO.getId());
	}

	private UserTO createNewUser() {
		UserTO userTO = new UserTO();
		userTO.setUsername("admin");
		userTO.setPassword("admin");
		return userService.createUser(userTO);
	}
	@Test @Ignore
	public void testCreateUser() {
		UserTO UserTO = createNewUser();
		assertNotNull(UserTO);
		//deleteUser(UserTO.getId());
	}
	
	private void deleteUser(int id) {
		userService.deleteUser(id);
	}

	@Test @Ignore
	public void testDeleteUser() {
		UserTO userTO = createNewUser();
		assertTrue(userService.deleteUser(userTO.getId()));
	}

	@AfterClass
	public static void cleanUp() {
	}

}
