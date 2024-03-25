package bai2.entities;

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

@Entity
@Table(name="profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	private String avatar;
	@Column(columnDefinition = "text")
	private String description;
//	?????
	@Id
	private long id;
	@OneToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
}
