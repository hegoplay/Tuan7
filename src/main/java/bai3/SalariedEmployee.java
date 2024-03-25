package bai3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="salaried_employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalariedEmployee extends Employee {
	@Column(columnDefinition = "float",name="weekly_salary",nullable = true)
	private double weeklySalary;

	@Override
	public double earning() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
