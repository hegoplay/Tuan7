package tuan1.dao;

import tuan1.entities.ClazzProfile;
import tuan1.entities.Course;

public class ClazzProfileDAO {
	public static ClazzProfile findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(ClazzProfile.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(ClazzProfile c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(ClazzProfile c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
