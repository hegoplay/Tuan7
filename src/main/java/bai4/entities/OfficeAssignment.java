package bai4.entities;

import java.sql.Timestamp;

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

//@Entity
//@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficeAssignment {
	@Column(name="Location")
	private String location;
	@Column(name="Timestamp")
	private Timestamp timestamp;
//	kha nang cao cho nay loi
	@OneToOne
	@JoinColumn(name="InstructorID")
	@Id
	private Instructor instructor;
}
