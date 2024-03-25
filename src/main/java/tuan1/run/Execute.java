package tuan1.run;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
		Constant.inputValues();
		StudentDAO.getSisoByLophoc();
		Map<Student, Float> ls = StudentDAO.listSinhvienDiemTB();
		
		for(Map.Entry<Student,Float> x : ls.entrySet()) {
			System.out.println(x.getKey());
		}
		Constant.closeConnection();
	}

}
