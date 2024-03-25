package bai2.entities;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "staffs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	private int age;
	@Id
	@Column(name="staff_id")
	private long id;
	@Column(name="staff_name")
	private String name;
	@ElementCollection
	@CollectionTable(name="phones", joinColumns = @JoinColumn(name = "staff_id"))
	@Column(name="numbers",nullable = false)
	private Set<String> phoneNumbers;
	@Column(name="refers")
	private String references;
	@ManyToOne
	@JoinColumn(name="staffs")
	private Department dept;
	@ManyToMany
	@JoinTable(
			name = "staff_projects",
			joinColumns = {@JoinColumn(name="staff_id")},
			inverseJoinColumns = {@JoinColumn(name="project_id")}
	)
	private Set<Project> projects;
	@OneToOne(mappedBy = "staff")
	private Profile profile;
	
}
