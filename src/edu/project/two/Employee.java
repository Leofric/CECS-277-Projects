package edu.project.two;

import java.util.Calendar;
import java.util.Comparator;

/**
 * This class is the base abstract class of the project used to make the other
 * subclasses.
 * 
 * @author alexberthon
 * @version 1.0
 */
public abstract class Employee implements Comparable<Employee>, Cloneable {
	private String firstName;
	private String lastName;
	private String IDNumber;
	private String gender;
	private Calendar birthday;

	/**
	 * This method gets the first name of the employee
	 * 
	 * @return returns the first name, type String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method gets the last name of the employee
	 * 
	 * @return returns the last name, type String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method gets the ID number of the employee.
	 * 
	 * @return returns the ID number, type String.
	 */
	public String getIDNumber() {
		return IDNumber;
	}

	/**
	 * This method gets the gender of the employee.
	 * 
	 * @return the gender, type String.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method gets the birth date of the employee.
	 * 
	 * @return the birth date, type Calendar.
	 */
	public Calendar getBirthday() {
		return birthday;
	}

	// Setters
	/**
	 * This method changes the first name of the employee.
	 * 
	 * @param first
	 *            the new name, type String.
	 */
	public void setFirstName(String first) {
		firstName = first;
	}

	/**
	 * This method changes the last name of the employee.
	 * 
	 * @param last
	 *            the new last name, type String.
	 */
	public void setLastName(String last) {
		lastName = last;
	}

	/**
	 * This method changes the ID number of the employee.
	 * 
	 * @param ID
	 *            the new ID number, type String
	 */
	public void setIDNumber(String ID) {
		IDNumber = ID;
	}

	/**
	 * This method changes the gender of the employee
	 * 
	 * @param gender
	 *            the new gender, type String.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method changes the birth date of the employee.
	 * 
	 * @param birthday
	 *            the new birthdate, type Calendar.
	 */
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	// Constructors
	/**
	 * This is the default constructor.
	 */
	public Employee() {
		firstName = "Unknown";
		lastName = "Unknown";
		IDNumber = "Unknown";
		gender = "Unknown";
		birthday = null;
	}

	/**
	 * This is the overloaded constructor
	 * 
	 * @param firstName
	 *            first name of the employee
	 * @param lastName
	 *            last name of the employee
	 * @param ID
	 *            the id of the employee
	 * @param gender
	 *            the gender of the employee
	 * @param birthday
	 *            the birth date of the employee
	 */
	public Employee(String firstName, String lastName, String ID, String gender, Calendar birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		IDNumber = ID;
		this.gender = gender;
		this.birthday = birthday;
	}

	// public methods
	/**
	 * This method overrides the toString method to correctly format this
	 * object.
	 */
	public String toString() {
		return "ID Employee Number: " + IDNumber + "\nEmployee Name: " + firstName + " " + lastName + "\nGender: "
				+ gender + "\nBirthday: " + birthday.get(Calendar.MONTH) + "/" + birthday.get(Calendar.DAY_OF_MONTH)
				+ "/" + birthday.get(Calendar.YEAR) + "\n";
	}

	/**
	 * This method implements the abstract method monthlyEarnings to be used by
	 * the subclasses
	 * 
	 * @return returns the monthly earnings of the employee, type double.
	 */
	public abstract double monthlyEarnings();

	/**
	 * This method compares two employees based on their ID number.
	 */
	public int compareTo(Employee object) {
		return object.getIDNumber().compareTo(IDNumber);
	}

	/**
	 * This method compares two employees based on their last names.
	 */
	public static Comparator<Employee> lastNameComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getLastName().compareTo(e2.getLastName());
		}
	};

	/**
	 * This method is used to shallow copy an object.
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
