package bai5.dao;

import java.util.Date;
import java.util.List;

import bai5.entities.Order;
import bai5.entities.OrderItem;
import bai5.entities.Product;

public class OrderDAO {
	public static void insert(Order p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(p);
		Constant.manager.getTransaction().commit();
	}

	public static void update(Order p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(p);
		Constant.manager.getTransaction().commit();
	}

	public static List<Order> findAll() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Order.findAll", Order.class).getResultList();
	}

	public static Order findByID(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Order.class, id);
	}

	public static void deleteByID(int id) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.remove(findByID(id));
		Constant.manager.getTransaction().commit();
	}

//	5. Tính tổng tiền của đơn hàng khi biết mã số đơn hàng.
	public static double getTotalPrice(int id) {
		Constant.manager.clear();
		return Constant.manager.createQuery(
				"SELECT SUM(oi.quantity * p.listPrice *oi.discount) FROM OrderItem oi JOIN oi.product p WHERE oi.order.id = :id",
				Double.class).setParameter("id", id).getSingleResult();
	}
//	8. Tính tổng tiền của tất cả các hóa đơn trong một ngày nào đó.
	public static double getTotalPriceByDate(Date date) {
		Constant.manager.clear();
		return Constant.manager.createQuery(
				"SELECT SUM(oi.quantity * p.listPrice *oi.discount) FROM OrderItem oi JOIN oi.product p WHERE oi.order.orderDate = :date",
				Double.class).setParameter("date", date.toString()).getSingleResult();
	}
//	10. Thống kê tổng tiền hóa đơn theo tháng / năm.
	public static double getTotalPriceByMonth(int month, int year) {
		Constant.manager.clear();
		return Constant.manager.createQuery(
				"SELECT SUM(oi.quantity * p.listPrice *oi.discount) FROM OrderItem oi JOIN oi.product p WHERE MONTH(oi.order.orderDate) = :month AND YEAR(oi.order.orderDate) = :year",
				Double.class).setParameter("month", month).setParameter("year", year).getSingleResult();
	}
}
