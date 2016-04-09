package com.tan90.notebook.web;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tan90.notebook.service.UserService;
import com.tan90.notebook.service.impl.UserServiceImpl;
import com.tan90.notebook.to.UserTO;

@Path("/users")
public class UserResource {

	private UserService userService;
	
	public UserResource() {
		userService = new UserServiceImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
}
