package bai5.dao;

import java.util.List;

import bai5.entities.Store;

public class StoreDAO {

	public static void insert(Store s) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(s);
		Constant.manager.getTransaction().commit();
	}

	public static void update(Store s) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(s);
		Constant.manager.getTransaction().commit();
	}

	public static void deleteByID(int id) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.remove(findByID(id));
		Constant.manager.getTransaction().commit();
	}

	public static Store findByID(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Store.class, id);
	}

	public static List<Store> findAll() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Store.findAll", Store.class).getResultList();
	}

}
