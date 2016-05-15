package com.tan90.notebook.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldService {

	
	@GET
	public String hello() {
		return "Hello world";
	}
	
}
