package bai1;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//@Entity
//@Table(name="groups")
public class Group 
{
	@Id
	@Column(name="group_id")
	private int id;
	
	@Column(length = 45)
	String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Group_User",
			joinColumns = {@JoinColumn(name="group_id")},
			inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	Set<User> users = new HashSet<>();
}
