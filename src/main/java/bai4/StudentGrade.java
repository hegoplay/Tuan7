package bai4;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class StudentGrade {
	@ManyToOne
	@JoinColumn(name="CourseID")
	private Course course;
	@Id
	@GeneratedValue
	private int enrollmentID;
	@Column(name="Grade")
	private double grade;
	@ManyToOne
	@JoinColumn(name="StudentID")
	private Student student;
	public StudentGrade(Course course, double grade, Student student) {
		super();
		this.course = course;
		this.grade = grade;
		this.student = student;
	}
	
}
