package bai3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="commission_employees")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommissionEmployee extends Employee{
	@Column(name="commission_rate",nullable = true)
	private double commissionRate;
	@Column(name="gross_sales",nullable = true)
	private double grossSales;
	@Override
	public double earning() {
		// TODO Auto-generated method stub
		return 0;
	}
}
