package tuan1.dao;

import tuan1.entities.Course;
import tuan1.entities.Enrollment;

public class EnrollmentDAO {
	public static Enrollment findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(Enrollment.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
		Constant.manager.getTransaction().commit();
	}
	public static void insert(Enrollment c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Enrollment c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
