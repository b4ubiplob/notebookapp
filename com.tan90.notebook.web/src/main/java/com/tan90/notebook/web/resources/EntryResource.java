package com.tan90.notebook.web.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tan90.notebook.service.EntryService;
import com.tan90.notebook.service.impl.EntryServiceImpl;
import com.tan90.notebook.to.EntryTO;

@Path("/entries")
public class EntryResource {

	private EntryService entryService = new EntryServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntryTO> getAllEntries() {
		int userId = 1;
		return entryService.getEntriesOfUser(userId);
	}
	
	
	
}
