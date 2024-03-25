package bai4;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instructor extends Person{
	@Column(name="HireDate")
	private LocalDateTime hireDate;
	
	@ManyToMany
	@JoinTable(
		name = "CourseInstructor",
		joinColumns = {@JoinColumn(name="PersonID")},
		inverseJoinColumns = {@JoinColumn(name="CourseID")}
	)
	private Set<Course> courses;
	
	@OneToOne(mappedBy = "instructor")
	private OfficeAssignment officeAssignment;
	
	
	public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}
	
}
