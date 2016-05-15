package com.tan90.notebook.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseUtil {
	
	private static final Logger logger =LoggerFactory.getLogger(DatabaseUtil.class);
	
	private static EntityManager entityManager;
	private static final String PERSISTENCE_UNIT = "notebook_pu";

	private DatabaseUtil() {
	}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			logger.info("initiaalizing EntityManager...");
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	public static void closeEntityManager() {
		entityManager.close();
		entityManager = null;
	}
	public static void startTransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	public static void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		getEntityManager().getTransaction().rollback();
	}

}
