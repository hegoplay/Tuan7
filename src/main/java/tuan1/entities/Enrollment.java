package tuan1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "enrollments")
@EqualsAndHashCode
public class Enrollment {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private Course course;
	@Id
	private String semester;
	@Id
	private int year;
	@EqualsAndHashCode.Exclude
	private int score;
}
