package edu.project.two;

import java.util.Calendar;

/**
 * This class is a subclass of employee, includes all employees, partime and
 * full time.
 * 
 * @author alexberthon
 * @version 1.0
 */
public class Staff extends Employee {

	private double hourlyRate;

	/**
	 * This is the default constructor
	 */
	public Staff() {
		super();
		hourlyRate = 0;
	}

	/**
	 * This is the overloaded constructor
	 * 
	 * @param hourlyRate
	 *            the hourly rate for the staff member.
	 * @param firstName
	 *            the first name of the staff member.
	 * @param lastName
	 *            the last name of the staff member.
	 * @param ID
	 *            the ID number of the staff member.
	 * @param gender
	 *            the gender of the staff member.
	 * @param birthday
	 *            the birth date of the staff member.
	 */
	public Staff(double hourlyRate, String firstName, String lastName, String ID, String gender, Calendar birthday) {
		super(firstName, lastName, ID, gender, birthday);
		this.hourlyRate = hourlyRate;
	}

	/**
	 * This method gets the hourly rate of the staff member.
	 * 
	 * @return The hourly rate, type doube.
	 */
	public double getRate() {
		return hourlyRate;
	}

	/**
	 * This method changes the hourly rate of the staff member.
	 * 
	 * @param rate
	 *            the new rate, type double.
	 */
	public void setRate(double rate) {
		this.hourlyRate = rate;
	}

	/**
	 * This method returns the monthly earnings of the staff member.
	 */
	public double monthlyEarnings() {
		return hourlyRate * 160;
	}

	/**
	 * This method overrides the toString method to correctly format this
	 * object.
	 */
	public String toString() {
		return super.toString() + "Full Time Monthly Salary: " + monthlyEarnings();
	}
}
