package tuan1.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import tuan1.entities.Clazz;

class ClazzDAOTest {

	@BeforeAll
	static void init() {
		Constant.getConnection();
		Constant.inputValues();
	}
	
	@AfterAll
	static void end() {
		Constant.closeConnection();
	}
	
	@Test
	void testClazzNoStudent() {
		List<Clazz> ls = ClazzDAO.listLophocNull();
		assertNotNull(ClazzDAO.findById("CS50"));
		assertNotNull(ClazzDAO.findById("AI1"));
		assertEquals(1,ls.size());
	}

}
