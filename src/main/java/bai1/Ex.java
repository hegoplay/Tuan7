package bai1;

import bai4.dao.Constant;
import jakarta.persistence.EntityManager;

public class Ex {
	public static void main(String[] args) {
		Constant.getConnection();
		EntityManager manager = Constant.manager;
//		Constant.inputValues();s
		Constant.closeConnection();
	}
}
