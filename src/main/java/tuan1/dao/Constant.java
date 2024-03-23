package tuan1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Constant {
	public static EntityManagerFactory entityFactory;
	public static EntityManager manager;
	public static void getConnection() {
		entityFactory = Persistence.createEntityManagerFactory("JPA_ORM_Student_MSSQL");
		manager = entityFactory.createEntityManager();
	}
	public static void closeConnection() {
		manager.close();
		entityFactory.close();
	}
}
