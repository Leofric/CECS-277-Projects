package edu.project.three;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main class, implements the user interface.
 * @author alexberthon
 * @version 1.0
 */
public class BankReader {

	/**
	 * this method gets the file name from the console
	 * @param in the input scanner, type Scanner
	 * @return the file name, type String
	 */
	private static String getFileName(Scanner in){
		String fileName = null;
		System.out.println("Please enter the name of the file to read");
		fileName = in.next();
		return fileName;
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner in = new Scanner(System.in);
		String fileName = getFileName(in);
		
		boolean done = false;
		while(!done){
			try{
				bank.readFile(fileName);
				System.out.println("Highest Balance: \n"+bank.getHighestBalance().toString());
				done = true;
			}
			catch (FileNotFoundException a){
				System.err.println("\n"+fileName+" Not found");
				fileName = getFileName(in);
			}
			catch (IOException e){
				System.err.println(fileName+" Contains improperly formatted line");
				fileName = getFileName(in);
			}
		}		
	}
}
