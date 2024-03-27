package bai5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@ToString
public class Address {
	@Column(nullable = true)
	private String street;
	@Column(nullable = true)
	private String city;
	@Column(nullable = true)
	private String state;
	@Column(name = "zip_code", nullable = true)
	private int zipCode;

}
