package com.tan90.notebook.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.tan90.notebook.service.impl.NotebookServiceImpl;
import com.tan90.notebook.to.NotebookTO;

public class NotebookServiceTest {

	private static NotebookService notebookService;
	
	@BeforeClass
	public static void init() {
		notebookService = new NotebookServiceImpl();
	}
	
	private NotebookTO getNewNotebookTO() {
		NotebookTO notebookTO = new NotebookTO();
		notebookTO.setName("first notebook");
		notebookTO.setUserId(1);
		notebookTO.setNotebookTypeId(1);
		return notebookTO;
	}
	
	@Test @Ignore
	public void testCreateNotebook() {
		assertNotNull(notebookService.createNotebook(getNewNotebookTO()));
	}

	@Test @Ignore
	public void testRemoveNotebook() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testUpdateNotebook() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testGetNotebooksOfUser() {
		fail("Not yet implemented");
	}

	@AfterClass
	public static void cleanup() {
		
	}
}
