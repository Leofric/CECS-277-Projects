package edu.project.six;

public class Employee implements Comparable<Employee> {
	private String firstName;
	private String lastName;
	private int ID; // unique

	public Employee() {
		firstName = "fub";
		lastName = "city";
		ID = 0;
	}

	public Employee(String first, String last, int ID) {
		firstName = first;
		lastName = last;
		this.ID = ID;
	}

	public String print() {
		return firstName + " " + lastName + " " + ID + " ";
	}

	public int hashCode() {
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer) ID).hashCode();
		return h;
	}

	public int compareTo(Employee a) {
		return this.lastName.compareTo(a.lastName);
	}
}
