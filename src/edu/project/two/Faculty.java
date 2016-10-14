package edu.project.two;

import java.util.Calendar;

/**
 * This class is a subclass of the employee object for full time employees
 * 
 * @author alexberthon
 * @version 1.0
 */
public class Faculty extends Employee implements EmployeeInfo, Cloneable {

	public enum Level {
		AS, AO, FU
	}

	private Education education;
	private Level level;

	/**
	 * Default constructor.
	 */
	public Faculty() {
		education = null;
		level = null;
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param education
	 *            the education of the faculty member.
	 * @param level
	 *            the job level of the faculty member.
	 * @param firstName
	 *            the first name of the faculty member.
	 * @param lastName
	 *            the last name of the faculty member.
	 * @param ID
	 *            the ID number of the faculty member.
	 * @param gender
	 *            the gender of the faculty member.
	 * @param birthday
	 *            the birth date of the faculty member.
	 */
	public Faculty(Education education, Level level, String firstName, String lastName, String ID, String gender,
			Calendar birthday) {
		super(firstName, lastName, ID, gender, birthday);
		this.education = education;
		this.level = level;
	}

	/**
	 * This method returns the education object of the faculty member.
	 * 
	 * @return the education of the faculty, type Education.
	 */
	public Education getEducation() {
		return education;
	}

	/**
	 * This method returns the level of the faculty member
	 * 
	 * @return
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * This mehtod changes the education of a faculty member
	 * 
	 * @param education
	 *            the new education to be applied, type Education.
	 */
	public void setEducation(Education education) {
		this.education = education;
	}

	/**
	 * This method changes the level of the faculty member.
	 * 
	 * @param level
	 *            the new level to be applied, type Level.
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * This method returns the montly earnings of the faculty member based on
	 * their level.
	 */
	public double monthlyEarnings() {
		double monthlyEarnings = 0;
		switch (level) {
		case AS:
			monthlyEarnings = FACULTY_MONTHLY_SALARY;
			break;
		case AO:
			monthlyEarnings = FACULTY_MONTHLY_SALARY * 1.2;
			break;
		case FU:
			monthlyEarnings = FACULTY_MONTHLY_SALARY * 1.4;
			break;
		}
		return monthlyEarnings;
	}

	/**
	 * This method overrides the toString method to correctly format this
	 * object.
	 */
	public String toString() {
		String title = "";
		switch (level) {
		case AS:
			title = "Associate";
			break;
		case AO:
			title = "Assistant";
			break;
		case FU:
			title = "Full";
			break;
		}
		return super.toString() + title + " Professor " + "\nMonthly Salary: " + monthlyEarnings();
	}

	/**
	 * This method performs a deep copy on this object
	 */
	public Object clone() throws CloneNotSupportedException {
		Faculty f = (Faculty) super.clone();
		education = (Education) education.clone();
		return f;
	}
}