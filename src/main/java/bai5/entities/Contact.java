package bai5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Contact {
	@Column(nullable = true)
	private String phone;
	@Column(nullable = true)
	private String email;

}
