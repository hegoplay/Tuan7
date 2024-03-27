package bai5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stocks")

public class Stock {
	@ManyToOne
	@JoinColumn(name = "store_id")
	@Id
	private Store store;
	@ManyToOne
	@JoinColumn(name = "product_id")
	@Id
	private Product product;
	private int quantity;

}
