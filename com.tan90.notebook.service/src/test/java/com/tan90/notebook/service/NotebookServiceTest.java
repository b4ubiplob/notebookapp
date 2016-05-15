package com.tan90.notebook.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.tan90.notebook.service.impl.NotebookServiceImpl;
import com.tan90.notebook.to.NotebookTO;

@Ignore
public class NotebookServiceTest {

	private static NotebookService notebookService;
	
	@BeforeClass
	public static void init() {
		notebookService = new NotebookServiceImpl();
	}
	
	private NotebookTO getNewNotebookTO(int num) {
		num++;
		NotebookTO notebookTO = new NotebookTO();
		notebookTO.setName("test notebook " + num);
		notebookTO.setUserId(1);
		notebookTO.setNotebookTypeId(1);
		return notebookTO;
	}
	
	@Test
	public void testCreateNotebook() {
		int size = notebookService.getAllNotebooks().size();
		notebookService.createNotebook(getNewNotebookTO(size), 1);
		int newSize = notebookService.getAllNotebooks().size();
		assertEquals(newSize, size + 1);
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
