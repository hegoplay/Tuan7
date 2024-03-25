package tuan1.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@Entity
//@Table(name = "fulltime_students")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class FullTimeStudent extends Student{
	private String faculty;
	private String department;
	public FullTimeStudent(String id, String name, String email, LocalDate dob, String faculty, String department) {
		super(id, name, email, dob);
		this.faculty = faculty;
		this.department = department;
	}
	public FullTimeStudent(String id, String name, String email, LocalDate dob, Set<String> phones, Address address,
			Gender gender, Clazz clazz, String faculty, String department) {
		super(id, name, email, dob, phones, address, gender, clazz);
		this.faculty = faculty;
		this.department = department;
	}
	
	
}
