package bai4.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {
	@Column(name = "Credits")
	protected int credits;
	
	@Id
	@GeneratedValue
	@Column(name="CourseID")
	protected int id;
	@Column(name="Title")
	protected String title;
//	CouresID and PersonID table
	@ManyToMany(mappedBy = "courses")
	private Set<Instructor> instructors;
	
//	map courseID to studentGrade
	@OneToMany(mappedBy = "course")
	private Set<StudentGrade> studentGrades;
	
	@ManyToOne
	@JoinColumn(name="DepartmentID")
	private Department department;
	
	public Course(int id) {
		super();
		this.id = id;
	}

	public Course(int credits, String title) {
		super();
		this.credits = credits;
		this.title = title;
	}
	
}
