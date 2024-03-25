package bai2.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department {
	@Id
	@Column(name = "dept_id",length=50)
	@EqualsAndHashCode.Include
	private String id;
	
	private String location;
	@Column(name = "dept_name")
	private String name;
	
	@OneToMany(mappedBy = "dept")
	Set<Staff> staffs;
	
	
}
