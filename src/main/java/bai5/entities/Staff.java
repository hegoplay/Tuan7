package bai5.entities;

import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "staffs")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "staff_id"))
@Getter
@Setter
@NoArgsConstructor
// I want to rename id to staff_id

public class Staff extends Person {
	@Column(columnDefinition = "TINYINT", nullable = false)
	private byte active;
	@OneToMany(mappedBy = "manager")
	private Set<Staff> staffs;
	@ManyToOne
	@JoinColumn(name = "manager_id", nullable = true)
	private Staff manager;
	@OneToMany(mappedBy = "staff")
	private Set<Order> orders;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = true)
	private Store store;

}
