package tuan1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "course_id")
	private String id;
	@Column(columnDefinition = "nvarchar(100)", unique=true,nullable = false)
	private String name;
	private int credits;
}
