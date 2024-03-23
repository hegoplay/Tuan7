package tuan1.dao;

import tuan1.entities.Enrollment;
import tuan1.entities.Student;

public class StudentDAO {
	public static Student findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(Student.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
		Constant.manager.getTransaction().commit();
	}
	public static void insert(Student c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Student c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
