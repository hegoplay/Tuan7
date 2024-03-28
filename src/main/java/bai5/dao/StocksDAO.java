package bai5.dao;

import java.util.List;

import bai5.entities.Product;
import bai5.entities.Stock;
import bai5.entities.Store;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class StocksDAO {
	public static void insert(Stock s) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(s);
		Constant.manager.getTransaction().commit();
	}

	public static void update(Stock s) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(s);
		Constant.manager.getTransaction().commit();
	}

	public static Stock find(Store s, Product p) {
		Constant.manager.clear();
		CriteriaBuilder builder = Constant.manager.getCriteriaBuilder();
		CriteriaQuery<Stock> cq = builder.createQuery(Stock.class);
		Root<Stock> root = cq.from(Stock.class);
		root.join("store");
		root.join("product");
		cq.select(root).where(builder.equal(root.get("store"), s), builder.equal(root.get("product"), p));
		return Constant.manager.createQuery(cq).getSingleResult();
	}

	public static List<Stock> findAll() {
		Constant.manager.clear();
		return Constant.manager.createNamedQuery("Stock.findAll", Stock.class).getResultList();
	}
}
