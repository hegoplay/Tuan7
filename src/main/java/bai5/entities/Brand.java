package bai5.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "brands")
@Entity
@NoArgsConstructor
@ToString
public class Brand {
	@Id
	@Column(name = "brand_id")
	private int id;
	@Column(name = "brand_name",nullable = true)
	private String name;
	@OneToMany(mappedBy = "brand")
	private Set<Product> products;
}
