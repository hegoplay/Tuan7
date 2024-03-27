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
@Entity
@Table(name="categories")
@NoArgsConstructor
@ToString
public class Category {
	@Id
	@Column(name="category_id")
	private int id;
	@Column(name="category_name")
	private String name;
	@OneToMany(mappedBy="category")
	private Set<Product> products;
	
	
}
