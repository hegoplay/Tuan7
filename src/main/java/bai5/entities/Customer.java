package bai5.entities;

import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@Getter
@Setter
@ToString(callSuper = true,exclude = "orders")
@NoArgsConstructor
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer extends Person {
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;
}
