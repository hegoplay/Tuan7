package bai5.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "brands")
@Entity
@NoArgsConstructor
@ToString(exclude = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b")
public class Brand {
	@Id
	@Column(name = "brand_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	@Column(name = "brand_name", nullable = true)
	private String name;
	@OneToMany(mappedBy = "brand")
	private Set<Product> products;
}
