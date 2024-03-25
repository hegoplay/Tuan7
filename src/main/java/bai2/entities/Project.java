package bai2.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Entity
//@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Column(columnDefinition = "float")
	private double budget;
	@Id
	@Column(name="project_id")
	private String id;
	@Column(name="project_name")
	private String name;
	@ManyToMany(mappedBy = "projects")
	private Set<Staff> staffs;
}
