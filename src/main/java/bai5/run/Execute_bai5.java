package bai5.run;

import java.util.List;
import java.util.Map;

import bai5.dao.PersonDAO;
import bai5.dao.Constant;
import bai5.dao.OrderDAO;
import bai5.dao.OrderItemDAO;
import bai5.dao.ProductDAO;
import bai5.dao.StocksDAO;
import bai5.dao.StoreDAO;
import bai5.entities.Customer;
import bai5.entities.Order;
import bai5.entities.OrderItem;
import bai5.entities.Person;
import bai5.entities.Product;
import bai5.entities.Stock;

public class Execute_bai5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constant.getConnection();
//		Stock stock = StocksDAO.find(StoreDAO.findByID(1), ProductDAO.findByID(3));
//		System.out.println(stock.getQuantity());
//		System.out.println(OrderDAO.getTotalPriceByMonth(1, 2016));
		Constant.closeConnection();
	}
}
