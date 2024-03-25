package bai4;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class Department {
	@Column(name="Administrator")
	private int administrator;
	@Column(name="Budget")
	private double budget;
	@Id
	@Column(name="DepartmentID")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="StartDate")
	private LocalDateTime startDate;
	
	@OneToMany(mappedBy = "department")
	private Set<Course> courses;
	public Department(int administrator, double budget, int id, String name, LocalDateTime startDate) {
		this.administrator = administrator;
		this.budget = budget;
		this.id = id;
		this.name = name;
		this.startDate = startDate;
	}
	
}
