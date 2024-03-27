package bai5.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "product_id")
	private int id;
	@Column(name = "product_name", nullable = true)
	private String name;
	@Column(name = "model_year", nullable = true)
	private int modelYear;
	@Column(columnDefinition = "decimal(10,2)", name = "list_price", nullable = true)
	private double listPrice;
	@OneToMany(mappedBy = "product")
	private Set<OrderItem> items;
	@OneToMany(mappedBy = "product")
	private Set<Stock> stocks;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = true)
	private Brand brand;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private Category category;

}
