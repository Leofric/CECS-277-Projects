package edu.project.two;

import java.util.Calendar;

/**
 * This class is a subclass of staff, for part time workers
 * 
 * @author alexberthon
 *
 */
public class Partime extends Staff {

	private double hours;

	/**
	 * The default constructor.
	 */
	public Partime() {
		hours = 0;
	}

	/**
	 * The overloaded constructor
	 * 
	 * @param hours
	 *            the number of hours worked, type double.
	 * @param hourlyRate
	 *            the hourly rate paid, type double.
	 * @param firstName
	 *            the first name of the partime staff member, type String.
	 * @param lastName
	 *            the last name of the partime staff member, type String.
	 * @param ID
	 *            the ID number of the partime staff member, type String.
	 * @param gender
	 *            the gender partime staff member, type String.
	 * @param birthday
	 *            the birth date of the partime staff member, type Calendar.
	 */
	public Partime(double hours, double hourlyRate, String firstName, String lastName, String ID, String gender,
			Calendar birthday) {
		super(hourlyRate, firstName, lastName, ID, gender, birthday);
		this.hours = hours;
	}

	/**
	 * This method returns the hours worked.
	 * 
	 * @return returns the number of hours worked, type double.
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * This method changes the number of hours worked
	 * 
	 * @param hours
	 *            the new number of hours, type double.
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

	/**
	 * This method calculates the montly earnings of the partime staff member.
	 */
	public double monthlyEarnings() {
		return super.getRate() * hours * 4;
	}

	/**
	 * This method overrides the toString method to correctly format this
	 * object.
	 */
	public String toString() {
		return super.toString() + "\nHours worked per month " + hours;
	}
}
