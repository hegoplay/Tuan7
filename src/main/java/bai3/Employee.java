package bai3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
	
	@Id
	@Column(name="emp_id")
	private int id;
	@Column(name="first_name",nullable = true)
	private String firstName;
	
	@Column(name="last_name",nullable = true)
	private String lastName;
	@Column(name="ssn")
	private String socialSecurityNumber;
	
	public abstract double earning();
}
