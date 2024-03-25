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
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "parttime_students")
public class PartTimeStudent extends Student{
	
	private String supervisor;

	public PartTimeStudent(String id, String name, String email, LocalDate dob, Set<String> phones, Address address,
			Gender gender, Clazz clazz,String supervisor) {
		super(id, name, email, dob, phones, address, gender, clazz);
		this.supervisor = supervisor;
		// TODO Auto-generated constructor stub
	}
	
	
	
}
