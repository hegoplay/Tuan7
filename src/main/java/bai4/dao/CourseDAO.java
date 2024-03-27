package bai4.dao;

import bai4.entities.Course;
import jakarta.transaction.Transactional;

@Transactional
public class CourseDAO {
	public static Course findById(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Course.class, id);
	}
	public static void deleteById(int id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(Course c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Course c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
