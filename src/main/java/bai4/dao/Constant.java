package bai4.dao;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bai4.entities.Course;
import bai4.entities.Department;
import bai4.entities.Instructor;
import bai4.entities.OfficeAssignment;
import bai4.entities.OnlineCourse;
import bai4.entities.OnsiteCourse;
import bai4.entities.Person;
import bai4.entities.Student;
import bai4.entities.StudentGrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
		List<Department> departments = Arrays.asList(
				new Department(1, 80000, 1, "H Tower", LocalDateTime.now()),
				new Department(1, 90000, 2, "F Tower", LocalDateTime.now()),
				new Department(1, 80200, 3, "W Tower", LocalDateTime.now()));
		for(Department d : departments) {
			DepartmentDAO.insert(d);
		}
		List<Course> courses = Arrays.asList(
				new OnsiteCourse(4,"Unity","Monday","H3.2",LocalDateTime.now()),
				new OnlineCourse(3, "JPA", "youtube.com"),
				new OnlineCourse(3, "Hibernate", "youtube.com/bomman"));
		int i = 0;
		for(Course d : courses) {
			d.setDepartment(departments.get((i++)%departments.size()));
			CourseDAO.insert(d);
		}
		List<Person> p = Arrays.asList(
				new Student("Manh", 1, "Pham", LocalDateTime.now(), new HashSet<>()),
				new Student("Khoi", 2, "Nguyen", LocalDateTime.now(), new HashSet<>()),
				new Student("Long", 3, "Luu", LocalDateTime.now(), new HashSet<>()),
				new Instructor("Chi","Pham",  LocalDateTime.now())
		);
		for(Person x : p) {
			PersonDAO.insert(x);
		}
		List<OfficeAssignment> offices = Arrays.asList(
				new OfficeAssignment("Main Hall", Timestamp.valueOf(LocalDateTime.now().minusDays(2)), (Instructor)p.get(3))
				);
		((Instructor)p.get(3) ).setCourses(Set.of(courses.get(0),courses.get(1)));
		for(OfficeAssignment x : offices) {
			OfficeAssignmentDAO.insert(x);
		}
		List<StudentGrade> sgGrades = Arrays.asList(
				new StudentGrade(courses.get(0), 10, (Student)p.get(0)),
				new StudentGrade(courses.get(1), 8, (Student)p.get(0)));
		for(StudentGrade s : sgGrades) {
			StudentGradeDAO.insert(s);
		}
	}
}