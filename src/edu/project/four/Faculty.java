package edu.project.four;

public class Faculty implements Comparable<Faculty> {
	private String id;
	private String firstName;
	private String lastName;

	public Faculty() {
		id = "0";
		firstName = "Fub";
		lastName = "City";
	}

	public Faculty(String id, String first, String last) {
		this.id = id;
		firstName = first;
		lastName = last;
	}

	public String getID() {
		return id;
	}

	public int compareTo(Faculty b) {
		return b.getID().compareTo(this.id);
	}

	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nID: " + id;
	}
}
