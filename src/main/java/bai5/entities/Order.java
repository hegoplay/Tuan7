package bai5.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString(exclude = { "items" })
@NoArgsConstructor
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "order_status", columnDefinition = "TINYINT", nullable = true)
	private byte orderStatus;
	@Column(name = "order_date", nullable = true)
	private LocalDateTime orderDate;
	@Column(name = "required_date", nullable = true)
	private LocalDateTime requiredDate;
	@Column(name = "shipped_date", nullable = true)
	private LocalDateTime shippedDate;
	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = true)
	private Staff staff;
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> items;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;

}
