package tuan1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Clazz {
	@EqualsAndHashCode.Include
	@Id
	@Column(name="class_id")
	private String id;
	@Column(columnDefinition = "nvarchar(100)",nullable = false)
	private String name;
	private int noOfStudents;
	
	
	
}
