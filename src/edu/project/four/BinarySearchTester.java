package edu.project.four;

import java.util.GregorianCalendar;
import java.util.Scanner;

import edu.project.two.Education;
import edu.project.two.EmployeeInfo;
import edu.project.two.Faculty;

public class BinarySearchTester implements EmployeeInfo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer[] test = new Integer[5];
		System.out.println("Please enter 5 integers");
		for (int i = 0; i < 5; i++) {
			test[i] = in.nextInt();
		}
		InsertionSort.sort(test);
		System.out.println("Displaying sorted array..");
		for (int i = 0; i < 5; i++) {
			System.out.print(test[i]+", ");
		}
		System.out.println("\n");
		
		BinarySearch<Integer> bi = new BinarySearch<Integer>(test);
		System.out.println("Enter the data you wish to search for");
		int result = bi.search(in.nextInt());
		
		if (result < 0){
			System.out.println("The data you were looking for was not found");
		}
		else System.out.println("The data you were looking for was found at location " +result+" in the array\n" );
		
		System.out.println("Now testing on Employee class..");
		Faculty [] faculty = new Faculty[5];
		faculty [0] = new Faculty(new Education("Doctorate", "Mathmatics", "100"), Faculty.Level.FU, "Morgan", "De'Morgan", "100", "Male", new GregorianCalendar(1975, 3, 14));
		faculty [1] = new Faculty(new Education("Batchelors", "Physics", "2"), Faculty.Level.AS, "Caroline", "Dawson", "104", "Female", new GregorianCalendar(1990, 4, 10));
		faculty [2] = new Faculty(new Education("Batchelors", "Buisness", "0"), Faculty.Level.AS, "Joeseph", "Madieas", "289", "Male", new GregorianCalendar(2000, 1, 4));
		faculty [3] = new Faculty(new Education("Doctorate", "Music", "0"), Faculty.Level.FU, "William", "Clark", "102", "Male", new GregorianCalendar(1975, 3, 14));
		faculty [4] = new Faculty(new Education("Masters", "Computer Science", "2"), Faculty.Level.FU, "Serah", "Villiers", "103", "Female", new GregorianCalendar(1987, 7, 18));

		System.out.println("Printing original Faculty Array");
		for (Faculty e : faculty){
			System.out.println(e+"\n");
		}
		
		InsertionSort.sort(faculty); //currently sorts by ID number, is that OK?
		
		System.out.println("Printing sorted Faculty Array");
		for (Faculty e : faculty){
			System.out.println(e+"\n");
		}

//		So.. what are we searching for here?? 
//		BinarySearch<Faculty> fa = new BinarySearch<Faculty>(faculty);
//		System.out.println("Enter the __ of the Faculty memeber you wish to search for");
//		result = fa.search(?);
//		if (result < 0){
//			System.out.println("The data you were looking for was not found");
//		}
//		else System.out.println("The data you were looking for was found at location " +result+" in the array\n" );
//		in.close();
	}
}
