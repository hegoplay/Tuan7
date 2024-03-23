package tuan1.dao;

import tuan1.entities.Clazz;
import tuan1.entities.ClazzProfile;

public class ClazzDAO {
	public static Clazz findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(Clazz.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(Clazz c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Clazz c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
