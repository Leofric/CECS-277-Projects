package edu.project.three;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class simulates a basic bank account with an account number and a balance
 * that can be altered or created by reading a data file
 * 
 * @author alexberthon
 * @version 1.0
 */
public class BankAccount {

	private double balance;
	private int accountNumber;
	
	/**
	 * Default constructor
	 */
	public BankAccount(){
		balance = 0;
		accountNumber = 0;
	}
	
	/**
	 * Overloaded constructor, sets initial values to accountNumber and balance
	 * 
	 * @param balance the balance of the account, type double
	 * @param accountNumber the account number, type int
	 */
	public BankAccount(double balance, int accountNumber){
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	/**
	 * This method reads data from the file and sets it to the balance and accountNumber
	 * 
	 * @param reader the file scanner object, type scanner
	 * @throws IOException checks for invalid data in the file
	 */
	public void read(Scanner reader) throws IOException{
		try{
			
			balance = reader.nextDouble();
			accountNumber = reader.nextInt();

		}
		catch(NoSuchElementException e){
			throw new IOException();
		}
	}
	
	/**
	 * adds money to the balance
	 * 
	 * @param amount the amount to be added
	 */
	public void deposit(double amount){
		balance += amount;
	}
	
	/**
	 * subtracts from the balance
	 * @param amount
	 */
	public void withdraw(double amount){
		balance -= amount;
	}
	
	/**
	 * this method returns the balance of the account
	 * @return the balance of the account, type double
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * this method returns the account number
	 * @return the accountNumber, type int
	 */
	public int getAccountNumber(){
		return accountNumber;
	}
	
	/**
	 * this method overloads the toString method to format the output of this object
	 */
	public String toString(){
		return "Account Number: "+accountNumber+" - Balance: "+balance;
	}
}
