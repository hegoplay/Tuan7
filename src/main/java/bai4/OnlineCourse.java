package bai4;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="OnlineCourse")
@NoArgsConstructor
@Getter
@Setter
public class OnlineCourse extends Course{
	@Column(name="URL")
	private String url;

	public OnlineCourse(int credits, String title, String url) {
		super(credits, title);
		this.url = url;
	}
	
}
