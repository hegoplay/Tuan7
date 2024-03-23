package tuan1.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "classes_profiles")
@Entity
public class ClazzProfile {
	private LocalDate createDate;
	@Column(columnDefinition = "nvarchar(255)")
	private String description;
	@Id
	@Column(name = "profile_id")
	private String id;
	@OneToOne
	@JoinColumn(name="class_id",unique = true,nullable = false)
	private Clazz clazz;
}
