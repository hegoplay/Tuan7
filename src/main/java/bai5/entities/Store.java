package bai5.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
@ToString(exclude = { "staffs", "stocks" })
public class Store {
	@OneToMany(mappedBy = "store")
	private Set<Staff> staffs;
	@Id
	@Column(name = "store_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	@Column(name = "store_name")
	private String name;
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "store")
	private Set<Stock> stocks;

}
