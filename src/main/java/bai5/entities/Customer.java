package bai5.entities;

import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@Table(name = "customers")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Customer extends Person {
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;
}
