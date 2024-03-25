package tuan1.dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tuan1.entities.Address;
import tuan1.entities.Clazz;
import tuan1.entities.ClazzProfile;
import tuan1.entities.Course;
import tuan1.entities.Enrollment;
import tuan1.entities.FullTimeStudent;
import tuan1.entities.Gender;
import tuan1.entities.PartTimeStudent;
import tuan1.entities.Student;

public class Constant {
	public static EntityManagerFactory entityFactory;
	public static EntityManager manager;
	public static void getConnection() {
		entityFactory = Persistence.createEntityManagerFactory("JPA_ORM_Student_MSSQL");
		manager = entityFactory.createEntityManager();
	}
	public static void closeConnection() {
		manager.close();
		entityFactory.close();
	}
	public static void inputValues() {
		CourseDAO.insert(new Course("1", "AWS", 4));
		CourseDAO.insert(new Course("LTPT_JAVA","Lập Trình Phân tán với Công Nghệ Java", 4));
		ClazzDAO.insert(new Clazz("AI1", "B3.9", 45));
		ClazzDAO.insert(new Clazz("CS50","B1.10",30)); 
		List<Student> students = Arrays.asList(
				new PartTimeStudent("ST01", "Redbull", "dxht@gmail.com", LocalDate.now(), 
						Stream.of("0944713015").collect(Collectors.toSet()), 
						new Address("street 6", "HCMC", "TDC", 713000), Gender.MALE, ClazzDAO.findById("AI1"),"M. BNTT"),
				new FullTimeStudent("ST02", "DTQ", "dtq@gmail.com", LocalDate.now(), 
						Stream.of("0376626025").collect(Collectors.toSet()), 
						new Address("le van viet street", "HCMC", "TDC", 713000), Gender.MALE, ClazzDAO.findById("AI1"), 
						"IT", "B3"));
		ClazzProfileDAO.insert(new ClazzProfile(LocalDate.now(), "Lop Tri tue nhan tao", "AIB309", ClazzDAO.findById("AI1")));
		ClazzProfileDAO.insert(new ClazzProfile(LocalDate.now(), "Lop Khoa hoc may tinh", "CS50B110", ClazzDAO.findById("CS50")));
		for(Student s : students) {
			StudentDAO.insert(s);
		}
		EnrollmentDAO.insert(new Enrollment(students.get(0), CourseDAO.findById("1"),"1st Semester" , 2020, 10));
		EnrollmentDAO.insert(new Enrollment(students.get(1), CourseDAO.findById("1"),"1st Semester" , 2020, 10));
		EnrollmentDAO.insert(new Enrollment(students.get(0), CourseDAO.findById("LTPT_JAVA"),"1st Semester" , 2021, 10));
		EnrollmentDAO.insert(new Enrollment(students.get(1), CourseDAO.findById("LTPT_JAVA"),"1st Semester" , 2021, 9));
//		System.out.println(CourseDAO.findById("1"));
//		System.out.println(ClazzDAO.findById("1"));
//		System.out.println(StudentDAO.findById("ST01"));
	}
}
