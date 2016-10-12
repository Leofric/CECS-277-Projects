package edu.project.three;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class simulates a simple bank, stores an array list of bank account objects
 * and can find the account with the highest balance
 * 
 * @author alexberthon
 * @version 1.0
 */
public class Bank {

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	/**
	 * This method creates a scanner for the data file, if the file exists, and reads it.
	 * 
	 * @param fileName the name of the file to be read, type String
	 * @throws IOException extends invalid input exception
	 */
	public void readFile(String fileName) throws IOException{
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		try{
			read(fileReader);
		}
		finally{
			fileReader.close();
		}
	}
	
	/**
	 * This method reads the data file set up in the readFile method
	 * and creates a new account to write that data to
	 * 
	 * @param reader the file scanner object, type Scanner
	 * @throws IOException extends invalid input exception
	 */
	public void read(Scanner reader) throws IOException{
		while(reader.hasNext()){
			BankAccount account = new BankAccount();
			account.read(reader);
			accounts.add(account);
		}
	}
	
	/**
	 * This method finds the account in the arraylist with the highest balance and returns it
	 * @return bankAccount with highest balance, type bankAccount
	 */
	public BankAccount getHighestBalance(){
		BankAccount highest = accounts.get(0);
		for (int i = 0; i<accounts.size(); i++){
			if(accounts.get(i).getBalance()>highest.getBalance()){
				highest = accounts.get(i);
			}
		}
		return highest;
	}
}
