package bai5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bai5.entities.Customer;
import bai5.entities.Product;

public class ProductDAO {
	public static void insert(Product p) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(p);
		Constant.manager.getTransaction().commit();
	}

	public static void update(Product p) {
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

	public static Product findByID(int id) {
		Constant.manager.clear();
		return Constant.manager.find(Product.class, id);
	}

	public static List<Product> findAll() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Product.findAll", Product.class).getResultList();
	}
	
//	2. Tìm danh sách sản phẩm có giá cao nhất.
	public static List<Product> getHighestPriceProduct(){
		Constant.manager.clear();
		return Constant.manager.createQuery("SELECT p FROM Product p WHERE p.listPrice = (SELECT MAX(p.listPrice) FROM Product p)", Product.class).getResultList();
	}
//	3. Tìm danh sách sản phẩm chưa bán được lần nào.
	public static List<Product> getProductNotInOrderItem(){
		Constant.manager.clear();
		return Constant.manager
				.createQuery("SELECT p FROM Product p WHERE p NOT IN (SELECT distinct oi.product FROM OrderItem oi)",
						Product.class)
				.getResultList();
	}
//	7. Tính tổng số lượng của từng sản phẩm đã bán ra.
//	+ getTotalProduct(): Map<Product, Integer>
	public static Map<Product, Integer> getTotalProduct() {
		Constant.manager.clear();
		List<Object[]> ls = Constant.manager
				.createQuery("SELECT oi.product, SUM(oi.quantity) FROM OrderItem oi GROUP BY oi.product",
						Object[].class)
				.getResultList();
		Map<Product, Integer> mp = new HashMap<Product, Integer>();
		for (Object[] x : ls) {
			mp.put((Product) x[0], ((Long) x[1]).intValue());
		}
		return mp;
	}
	
}
