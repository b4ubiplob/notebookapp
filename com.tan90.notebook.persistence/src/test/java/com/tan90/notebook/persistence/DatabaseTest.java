package com.tan90.notebook.persistence;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void connectionTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("notebook_pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager);
	}
	

}
