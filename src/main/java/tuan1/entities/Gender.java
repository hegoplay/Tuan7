package tuan1.entities;

public enum Gender {
	MALE("Male"),FEMALE("Female"),OTHER("Other");
	private String name;
	Gender(String name) {
		this.name=  name;
	}
	public String toString() {
		return name;
	}
}
