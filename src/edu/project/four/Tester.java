package edu.project.four;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Faculty[] faculty = new Faculty[3];
		faculty = initialize(faculty);
		Scanner in = new Scanner(System.in);
		int choice = 0;

		System.out.println("Welcome to lab 4 demo\n");

		while (choice != 5) {
			displayMenu();
			choice = in.nextInt();
			switch (choice) {
			case 1:
				demo1();
				break;
			case 2:
				print(faculty);
				break;
			case 3:
				InsertionSort.sort(faculty);
				print(faculty);
				break;
			case 4:
				searchArray(faculty, in);
				break;
			case 5:
				choice = 5;
				in.close();
				break;
			}
		}
	}

	static void searchArray(Faculty[] faculty, Scanner in) {
		BinarySearch<Faculty> searcher = new BinarySearch<Faculty>(faculty);
		System.out.println("Please enter the ID number you wish to search for");
		Faculty check = new Faculty(in.next(), "Fub", "City");

		int result = searcher.search(check);

		if (result < 0) {
			System.out.println("The data was not found");
		} else
			System.out.println("The data is located at index " + result + "\n");
	}

	static void displayMenu() {
		System.out.println("Press 1 to demo 1");
		System.out.println("Press 2 to print the faculty array");
		System.out.println("Press 3 to sort and print the faculty array (Insertion sort)");
		System.out.println("Press 4 to search for an ID number of a faculty member in the array");
		System.out.println("Press 5 to quit");
	}

	static void demo1() {
		ArrayList<MeasurableString> words = new ArrayList<MeasurableString>();
		words.add(new MeasurableString("Mary"));
		words.add(new MeasurableString("had"));
		words.add(new MeasurableString("a"));
		words.add(new MeasurableString("little"));
		words.add(new MeasurableString("lamb"));
		System.out.println("Printing array of Measurable Strings");
		System.out.print("[");
		for (int i = 0; i < words.size() - 1; i++) {
			System.out.print(words.get(i) + ",");
		}
		System.out.println(words.get(words.size() - 1) + "]\n");

		System.out.println("Largest word: " + Measurable.largest(words));
		System.out.println("Expected: little\n\n");
	}

	static Faculty[] initialize(Faculty[] faculty) {
		faculty[0] = new Faculty("0", "Morgan", "De'Morgan");
		faculty[1] = new Faculty("1", "William", "Clark");
		faculty[2] = new Faculty("2", "Serah", "Villiers");
		return faculty;
	}

	static void print(Faculty[] faculty) {
		System.out.println("---Printing Faculty Array---");
		for (Faculty e : faculty) {
			System.out.println(e + "\n");
		}
	}
}
