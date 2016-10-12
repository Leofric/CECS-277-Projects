package edu.project.two;

/**
 * This Class stores the education information to be used by faculty members in
 * the Faculty Class.
 * 
 * @author alexberthon
 * @version 1.0
 */
public class Education implements Cloneable {

	private String degree;
	private String major;
	private String research;

	/**
	 * This is the default constructor.
	 */
	public Education() {
		degree = "Unknown";
		major = "Unknown";
		research = "Unknown";
	}

	/**
	 * This is the overloaded constructor
	 * 
	 * @param degree
	 *            the degree level, type String.
	 * @param major
	 *            the major, type String.
	 * @param research
	 *            number of research projects completed, type String.
	 */
	public Education(String degree, String major, String research) {
		this.degree = degree;
		this.major = major;
		this.research = research;
	}

	/**
	 * This method returns the degree level
	 * 
	 * @return the degree level, type String.
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * This method returns the major
	 * 
	 * @return the major, type String.
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * This method returns the number of research projects completed.
	 * 
	 * @return the number of research projects, type String.
	 */
	public String getResearch() {
		return research;
	}

	/**
	 * This method changes the degree to the given input.
	 * 
	 * @param degree
	 *            the new degree to be changed, type String
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * this method changes the major to the given input.
	 * 
	 * @param major
	 *            the new major to be changed, type String.
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * This method changes the number of research projects completed
	 * 
	 * @param research
	 *            the new number of research projects completed, type String.
	 */
	public void setResearch(String research) {
		this.research = research;
	}

	/**
	 * This method is used to shallow copy an object.
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
