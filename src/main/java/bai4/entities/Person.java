package bai4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
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
//@Table(name="Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator")
//generate DTYPE column to distinguish which one is student or vice versa
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Person {
	@Column(name="FirstName")
	protected String firstName;
	@Id
	@Column(name = "PersonID")
	protected int id;
	@Column(name="LastName")
	protected String lastName;
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
