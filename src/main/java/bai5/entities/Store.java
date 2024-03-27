package bai5.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="stores")
public class Store {
	@OneToMany(mappedBy="store")
	private Set<Staff> staffs;
	@Id
	@Column(name="store_id")
	private int id;
	@Column(name="store_name")
	private String name;
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;
	@OneToMany(mappedBy="store")
	private Set<Stock> stocks;
	
}
