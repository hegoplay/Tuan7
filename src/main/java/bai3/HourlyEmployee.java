package bai3;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="hourly_employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HourlyEmployee extends Employee{
	
	private double hours;
	private double wage;
	@Override
	public double earning() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
