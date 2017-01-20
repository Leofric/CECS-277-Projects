package edu.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class simulates the basic functions addition, subtraction,
 * multiplication and division of two user defined fractions.
 * 
 * @author alexberthon
 * @version 1.0
 */
public class Fraction {

	private int numerator;
	private int denominator;

	/**
	 * Default constructor
	 */
	public Fraction() {
		numerator = 0;
		denominator = 1;
	}

	/**
	 * Overloaded Constructor, sets numerator and denominator values.
	 * 
	 * @param numerator
	 *            Defines the initial value of the numerator.
	 * @param denominator
	 *            Defines the initial value of the denominator
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * This method returns the current value of the numerator.
	 * 
	 * @return The value of the numerator, type int.
	 */
	public int getNumerator() {
		return this.numerator;
	}

	/**
	 * This method returns the current value of the denominator.
	 * 
	 * @return The value of the denominator, type int.
	 */
	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * This method changes the value of the numerator.
	 * 
	 * @param value
	 *            The value that will be assigned to the numerator.
	 */
	public void setNumerator(int value) {
		this.numerator = value;
	}

	/**
	 * This method changes the value of the denominator.
	 * 
	 * @param value
	 *            The value that will be assigned to the denominator.
	 */
	public void setDenominator(int value) {
		this.denominator = value;
	}

	/**
	 * This method sets the values of the numerator and denominator of the
	 * fraction to user defined values. Also checks for invalid input such as
	 * non int values and 0's in the denominator.
	 * 
	 * Side Note on Implementation:
	 * 2 types of errors can occur,
	 * 		1) User enters non-int value (a, -, +, etc.)
	 * 		throws inputmismatch exception, caught and handled below
	 * 		
	 * 		2) User enters 0 for the denominator section. 
	 * 		This also would throw an input mismatch exception, however it would then be handled by the same
	 * 		catch block as the first error which creates some issues. In the first error case, the scanner
	 * 		has to have its storage refreshed, otherwise when looping back to ask the user for valid data,
	 * 		it will use the first entry over and over resulting in an infinite loop. Refreshing the scanner
	 * 		in the second error case however is not needed and causes the user to have to enter a number twice
	 * 		for the sequence to start over normally. Therefore I handled each case as 2 distinct exceptions
	 * 		and created a catch block to handle both differently, thus the longer and less efficient code below.
	 */
	public void inputFraction() {
		Scanner in = new Scanner(System.in);
		Boolean valid = false;
		int value = 0;
		IllegalArgumentException e = new IllegalArgumentException(); //for denom = 0 exception
		while (!valid) {
			try {
				System.out.print("Please enter a integer for the numerator: ");
				value = in.nextInt();
				this.numerator = value;
				System.out.print("Please enter a integer for the denominator: ");
				value = in.nextInt(); 
				if (value < 1) {
					throw e;
				}
				this.denominator = value;
				valid = true;
			} catch (InputMismatchException x) {
				System.out.println("Invalid input, please try again.");
				in.next(); // refreshes scanner; without it, infinite loop.
			} catch (IllegalArgumentException y) {
				System.out.println("Invalid input, please try again.");
			}
			System.out.println();
		}
	}

	/**
	 * This method overrides the toString method to define how to print the
	 * fraction object.
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	/**
	 * This method calculates the gcd of a fraction in order to reduce it
	 * properly.
	 * 
	 * @param m
	 *            The value of the numerator.
	 * @param n
	 *            The value of the denominator.
	 * @return Returns the greatest common denominator.
	 */
	private int gcd(int m, int n) {
		// - return the greatest common divisor
		int r;
		while (n != 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}

	/**
	 * This method adds two fractions together.
	 * 
	 * @param f1
	 *            The fraction object that is to be added.
	 * @return Returns a fraction object that is the sum of the two fractions
	 *         provided.
	 */
	public Fraction add(Fraction f1) {
		int numerator = f1.getDenominator() * this.numerator + f1.getNumerator() * this.denominator;
		int denominator = f1.denominator * this.denominator;
		int co = gcd(numerator, denominator);
		numerator /= co; // equivalent to.. numerator = numerator / co
		denominator /= co; // equivalent to.. denominator = denominator / co
		return new Fraction(numerator, denominator);
	}

	/**
	 * This method subtracts two fractions.
	 * 
	 * @param f1
	 *            The fraction object that is to be subtracted.
	 * @return Returns a fraction object that is the difference of the two
	 *         fractions provided.
	 */
	public Fraction sub(Fraction f1) {
		int numerator = f1.getDenominator() * this.numerator - f1.getNumerator() * this.denominator;
		int denominator = f1.denominator * this.denominator;
		int co = gcd(numerator, denominator);
		numerator /= co;
		denominator /= co;
		return new Fraction(numerator, denominator);
	}

	/**
	 * This method multiplies two fractions together.
	 * 
	 * @param f1
	 *            The fraction object that is to be multiplied
	 * @return Returns a fraction object that is the product of the two
	 *         fractions provided.
	 */
	public Fraction mul(Fraction f1) {
		int numerator = f1.getNumerator() * this.numerator;
		int denominator = f1.getDenominator() * this.denominator;
		int co = gcd(numerator, denominator);
		numerator /= co;
		denominator /= co;
		return new Fraction(numerator, denominator);
	}

	/**
	 * This method divides two fractions.
	 * 
	 * @param f1
	 *            The fraction ojbect that is to be divided.
	 */
	public void div(Fraction f1) {
		int numerator = this.numerator * f1.getDenominator();
		int denominator = this.denominator * f1.getNumerator();
		int co = gcd(numerator, denominator);
		numerator /= co;
		denominator /= co;
		System.out
				.println(this.numerator + "/" + this.denominator + " / " + f1 + " = " + numerator + "/" + denominator);
	}

	/**
	 * This method divides 2 fractions and returns a decimal.
	 * 
	 * @param f1
	 *            The first fraction that is to be divided.
	 * @param f2
	 *            The second fraction to be divided.
	 * @return Returns the decimal value of the quotient, type double.
	 */
	public static double divFraction(Fraction f1, Fraction f2) {
		double numerator = f1.getNumerator() * f2.getDenominator();
		double denominator = f1.getDenominator() * f2.getNumerator();
		double reduced = numerator / denominator;
		return reduced;
	}
}
