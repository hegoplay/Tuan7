package bai3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="base_plus_commission_employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePlusCommissionEmployee extends CommissionEmployee{
	@Column(name = "base_salary",columnDefinition = "float",nullable = true)
	private double baseSalary;
}
