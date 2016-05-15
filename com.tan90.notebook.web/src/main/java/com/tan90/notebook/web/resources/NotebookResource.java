package com.tan90.notebook.web.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tan90.notebook.service.NotebookService;
import com.tan90.notebook.service.impl.NotebookServiceImpl;
import com.tan90.notebook.to.EntryTO;
import com.tan90.notebook.to.MessageTO;
import com.tan90.notebook.to.NotebookTO;
import com.tan90.notebook.to.NotebookTypeTO;

@Path("/notebooks")
public class NotebookResource {
	
	private NotebookService notebookService = new NotebookServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotebookTO> getAllNotebooks() {
		return notebookService.getNotebooksOfUser(1);
	}
	
	@GET
	@Path("/{id}/entries")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntryTO> getEntriesOfNotebook(@PathParam("id") int notebookId) {
		return notebookService.getEntriesOfNotebook(notebookId);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public NotebookTO getNotebook(@PathParam("id") int id) {
		return notebookService.getNotebook(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MessageTO create(NotebookTO notebookTO) {
		MessageTO messageTO = new MessageTO();
		if (notebookService.createNotebook(notebookTO, 1) != null) {
			messageTO.setMessage("OK");
		}
		else {
			messageTO.setMessage("ERROR");
		}
		return messageTO;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MessageTO update(@PathParam("id") int id, NotebookTO notebookTO) {
		MessageTO messageTO = new MessageTO();
		if (notebookService.updateNotebook(notebookTO)) {
			messageTO.setMessage("OK");
		}
		else {
			messageTO.setMessage("ERROR");
		}
		return messageTO;
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageTO remove(@PathParam("id") int id) {
		MessageTO messageTO = new MessageTO();
		if (notebookService.removeNotebook(id)) {
			messageTO.setMessage("OK");
		}
		else {
			messageTO.setMessage("ERROR");
		}
		return messageTO;
	}
	
	
	@GET
	@Path("/types")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotebookTypeTO> getNotebookTypes() {
		return notebookService.getAllNotebookTypes();
	}
	

}
