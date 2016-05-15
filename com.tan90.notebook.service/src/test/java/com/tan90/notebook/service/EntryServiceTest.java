package com.tan90.notebook.service;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.tan90.notebook.service.impl.EntryServiceImpl;
import com.tan90.notebook.to.EntryTO;

@Ignore
public class EntryServiceTest {
	
	private static EntryService entryService;
	
	@BeforeClass
	public static void init() {
		entryService = new EntryServiceImpl();
	}

	
	@Test @Ignore
	public void testCreateEntry() {
		Date date = new Date();
		EntryTO entryTO = new EntryTO();
		entryTO.setCreatedDate(date);
		entryTO.setDescription("sample description");
		entryTO.setEntryStatusId(1);
		entryTO.setLastModified(date);
		entryTO.setNotebookId(1);
		entryTO.setParentid(0);
		entryTO.setTargetDate(null);
		entryTO.setTitle("sample title");
		
		assertTrue(entryService.createEntry(entryTO));
	}
}
