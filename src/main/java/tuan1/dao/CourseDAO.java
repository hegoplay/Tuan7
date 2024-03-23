package tuan1.dao;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tuan1.entities.Course;

public class CourseDAO  {
	static EntityManagerFactory entityFactory = Constant.entityFactory;
	static EntityManager manager = Constant.manager;
	
	
	public static Course findById(String id) {
		manager.clear();
		
		return manager.find(Course.class, id);
		
	}
	public static void deleteById(String id) {
		manager.clear();
		manager.remove(findById(id));
	}
	public static void insert(Course c) {
		manager.clear();
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		
	}
	public static void update(Course c) {
		manager.clear();
		manager.getTransaction().begin();
		manager.merge(c);
		manager.getTransaction().commit();
		
	}
	
}
