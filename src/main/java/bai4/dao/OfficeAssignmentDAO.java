package bai4.dao;

import bai4.entities.Instructor;
import bai4.entities.OfficeAssignment;
import bai4.entities.StudentGrade;

public class OfficeAssignmentDAO {
	public static OfficeAssignment findById(int id) {
		Constant.manager.clear();
		return Constant.manager.find(OfficeAssignment.class,PersonDAO.findById(id));
	}
	public static void deleteById(int id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(OfficeAssignment c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(OfficeAssignment c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
