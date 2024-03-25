package bai1;

import jakarta.persistence.EntityManager;
import tuan1.dao.Constant;

public class Ex {
	public static void main(String[] args) {
		Constant.getConnection();
		EntityManager manager = Constant.manager;
		Constant.closeConnection();
	}
}
