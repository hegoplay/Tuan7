package bai5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bai5.entities.Customer;
import bai5.entities.Order;
import bai5.entities.Person;
import bai5.entities.Staff;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import bai5.dao.Constant;

public class PersonDAO {

	public static void insert(Person p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(p);
		Constant.manager.getTransaction().commit();
	}

	public static void update(Person p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(p);
		Constant.manager.getTransaction().commit();
	}

	public static void deleteByID(int id) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.remove(findByID(id));
		Constant.manager.getTransaction().commit();
	}

	public static Person findByID(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Person.class, id);
	}

	public static List<Customer> findAllCustomer() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
	}

	public static List<Staff> findAllStaff() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Staff.findAll", Staff.class).getResultList();
	}

	public static List<Person> findAll() {
		Constant.manager.clear();
		List<Person> p = new ArrayList<>();
		for (Customer c : findAllCustomer())
			p.add(c);
		for (Staff s : findAllStaff())
			p.add(s);
		return p;
	}
//	4. Thống kê số khách hàng theo từng bang.
//	+ getNumberCustomerByState() : Map<String, Integer>
	public static Map<String,Integer> getNumberCustomerByState(){
		Constant.manager.clear();
		Map<String,Integer> map = new HashMap<>();
		CriteriaBuilder cb = Constant.manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq= cb.createQuery(Tuple.class);
		
//		TypedQuery<Tuple> tq = Constant.manager.createQuery("SELECT c.state, COUNT(c) FROM Customer c GROUP BY c.state", Tuple.class);
		Root<Customer> c = cq.from(Customer.class);
		cq = cq.multiselect(c.get("address").get("state"),cb.count(c)).groupBy(c.get("address").get("state"));
		List<Tuple> ls = Constant.manager.createQuery(cq).getResultList();
		for (Tuple t : ls) {
			
			map.put((String) t.get(0), ((Long) t.get(1)).intValue());
		}
//		cq = cq.select(c.get("address").get("state")).distinct(true);
//		List<String> ls = Constant.manager.createQuery(cq).getResultList();
//		for(String s : ls) {
//			System.out.println(s);
//		}
		return map;
	}
//	6. Đếm số đơn hàng của từng khách hàng.
//	+ getOrdersByCustomers() : Map<Customer, Integer>\
	public static Map<Customer, Integer> getOrderByCustomer() {
		Map<Customer, Integer> map = new HashMap<>();
		Constant.manager.clear();
		CriteriaBuilder cb = Constant.manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
		
		Root<Order> c = cq.from(Order.class);
//		c.join("orders");
		cq = cq.multiselect(c.get("customer"), cb.count(c.get("customer"))).groupBy(c.get("customer"));
		List<Tuple> ls = Constant.manager.createQuery(cq).getResultList();
		for (Tuple t : ls) {
			map.put((Customer) t.get(0), ((Long) t.get(1)).intValue());
		}
		return map;
	}
//	9. Xóa tất cả các khách hàng chưa mua hàng.
	// + deleteCustomerNotOrder() : void
	public static void deleteCustomerNotOrder() {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		List<Customer> ls = Constant.manager
				.createQuery("SELECT c FROM Customer c WHERE c NOT IN (SELECT o.customer FROM Order o)", Customer.class)
				.getResultList();
		for (Customer c : ls) {
			Constant.manager.remove(c);
		}
		Constant.manager.getTransaction().commit();
	}
	
}
