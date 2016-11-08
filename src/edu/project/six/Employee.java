package edu.project.six;

/**
 * This Class stores information for a employee
 * @author alexberthon
 *
 */
public class Employee implements Comparable<Employee> {
	private String firstName;
	private String lastName;
	private int ID; // unique

	/**
	 * Default constructor
	 */
	public Employee() {
		firstName = "default";
		lastName = "constructor";
		ID = 0;
	}

	/**
	 * Overloaded constructor, create an employee with given info
	 * @param first the first name of the employee, type String
	 * @param last the last name of the employee, type String
	 * @param ID the unique ID number of the employee, type int
	 */
	public Employee(String first, String last, int ID) {
		firstName = first;
		lastName = last;
		this.ID = ID;
	}

	/**
	 * This method prints the info of the employee
	 * @return a string containing all of the employee information, type String
	 */
	public String print() {
		return firstName + " " + lastName + " " + ID + " ";
	}

	/**
	 * This method provides a reference for the hashCode function
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer) ID).hashCode();
		return h;
	}

	/**
	 * This method implements the comparable interface, defines how 2 employees are compared.
	 */
	public int compareTo(Employee a) {
		int toReturn;

		if(this.lastName.equals(a.lastName) && this.firstName.equals(a.firstName)){
			toReturn = Integer.compare(this.ID, a.ID);
		}
		else if(this.lastName.equals(a.lastName)){
			toReturn = this.firstName.compareTo(a.firstName);
		}
		else toReturn = this.lastName.compareTo(a.lastName);
		
		return toReturn;
	}
}
