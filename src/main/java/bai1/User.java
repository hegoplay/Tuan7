package bai1;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name ="username",length=45)
	private String userName;
	@Column(length=45)
	private String password;
	@Column(length=45)
	private String email;
	@ManyToMany(mappedBy = "users")
	
	private Set<Group> groups = new HashSet<>();
}
