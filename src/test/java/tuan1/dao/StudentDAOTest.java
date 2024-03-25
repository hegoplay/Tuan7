package tuan1.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import tuan1.entities.Student;

class StudentDAOTest {

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
	void findByIdTest() {
		
		
		Student student = StudentDAO.findById("ST01");
		assertEquals(student.getName(), "Redbull");
	}
	@Test
	void testAvgValue() {
		Map<Student, Float> ls = StudentDAO.listSinhvienDiemTB();
		
		assertEquals(ls.size(), 2);
		
		Student student = StudentDAO.findById("ST01");
		Constant.manager.detach(student);
		assertEquals(ls.get(student),10);
	}
	@Test
	void testSVGioiJava() {
		List<Student> ls = StudentDAO.listSinhvienGioiJava();
		assertEquals(1,ls.size());
		for(Student s : ls) {
			System.out.println(s);
		}
		
	}

}
