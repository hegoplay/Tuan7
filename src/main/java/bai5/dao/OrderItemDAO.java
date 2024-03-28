package bai5.dao;

import java.util.List;

import bai5.entities.OrderItem;
import bai5.entities.Product;

public class OrderItemDAO {
	public static void insert(OrderItem p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(p);
		Constant.manager.getTransaction().commit();
	}

	public static void update(OrderItem p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(p);
		Constant.manager.getTransaction().commit();
	}

	public static List<OrderItem> findAll() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("OrderItem.findAll", OrderItem.class).getResultList();
	}

}
