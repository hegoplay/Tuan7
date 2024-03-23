package tuan1.run;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.testing.orm.domain.userguide.Phone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tuan1.dao.ClazzDAO;
import tuan1.dao.ClazzProfileDAO;
import tuan1.dao.Constant;
import tuan1.dao.CourseDAO;
import tuan1.dao.EnrollmentDAO;
import tuan1.dao.StudentDAO;
import tuan1.entities.Address;
import tuan1.entities.Clazz;
import tuan1.entities.ClazzProfile;
import tuan1.entities.Course;
import tuan1.entities.Enrollment;
import tuan1.entities.Gender;
import tuan1.entities.PartTimeStudent;
import tuan1.entities.Student;

public class Execute {
	public static void main(String[] args) {
		Constant.getConnection();
		System.out.println("YES");
//		EnrollmentDAO.insert(
//				new Enrollment(
//						new Student("1", "Manh", "thmnh113@gmail.com", LocalDate.now()), 
//						CourseDAO.findById("1"), 
//						"2nd", 
//						2019, 
//						8));
		CourseDAO.insert(new Course("1", "AWS", 4));
		ClazzDAO.insert(new Clazz("B39", "B3.9", 45));
		ClazzProfileDAO.insert(new ClazzProfile(LocalDate.now(), "Lop KHMT", "KHMTB309", ClazzDAO.findById("B39")));
		StudentDAO.insert(new PartTimeStudent("ST01", "Redbull", "dxht@gmail.com", LocalDate.now(), 
				Stream.of("0944713015").collect(Collectors.toSet()), 
				new Address("street 6", "HCMC", "TDC", 713000), Gender.MALE, ClazzDAO.findById("B39"),"M. BNTT"));
		System.out.println(CourseDAO.findById("1"));
		System.out.println(ClazzDAO.findById("1"));
		System.out.println(StudentDAO.findById("ST01"));
		
		Constant.closeConnection();
	}
}
