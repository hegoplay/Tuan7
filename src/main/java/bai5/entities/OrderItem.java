package bai5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = {"product" })
@Table(name = "order_items")
@NoArgsConstructor
@NamedQuery(name = "OrderItem.findAll", query = "SELECT oi FROM OrderItem oi")
public class OrderItem {

	private int quantity;
	@Column(columnDefinition = "decimal(10,2)", nullable = true, name = "list_price")
	private double listPrice;
	@Column(columnDefinition = "decimal(4,2)", nullable = true)
	private double discount;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@Id
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	@Id
	private Product product;

}
