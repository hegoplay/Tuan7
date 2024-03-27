package bai4.dao;

import bai4.entities.Department;
import bai4.entities.OfficeAssignment;

public class DepartmentDAO {
	public static Department findById(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Department.class,id);
	}
	public static void deleteById(int id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(Department c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Department c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
