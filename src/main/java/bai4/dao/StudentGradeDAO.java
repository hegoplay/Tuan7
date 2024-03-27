package bai4.dao;

import bai4.entities.Course;
import bai4.entities.StudentGrade;

public class StudentGradeDAO {
	public static StudentGrade findById(int id) {
		Constant.manager.clear();
		return Constant.manager.find(StudentGrade.class,id);
	}
	public static void deleteById(int id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(StudentGrade c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(StudentGrade c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
