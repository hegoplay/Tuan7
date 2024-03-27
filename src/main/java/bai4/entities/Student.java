package bai4.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends Person{
	@Column(name="EnrollmenDate")
	private LocalDateTime enrollmentDate;
	@OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
	private Set<StudentGrade> studentsGrades;
	
	public Student(String firstName, String lastName, LocalDateTime enrollmentDate) {
		super(firstName, lastName);
		this.enrollmentDate = enrollmentDate;
	}

	public Student(String firstName, int id, String lastName, LocalDateTime enrollmentDate,
			Set<StudentGrade> studentsGrades) {
		super(firstName, id, lastName);
		this.enrollmentDate = enrollmentDate;
		this.studentsGrades = studentsGrades;
	}
	
	
}
