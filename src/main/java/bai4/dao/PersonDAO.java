package bai4.dao;

import bai4.entities.Person;
import jakarta.transaction.Transactional;

@Transactional
public class PersonDAO {
	public static Person findById(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Person.class, id);
	}
	public static void deleteById(int id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(Person c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Person c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
}
