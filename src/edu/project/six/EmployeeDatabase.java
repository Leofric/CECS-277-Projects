package edu.project.six;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeDatabase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Employee> employeeMap = new TreeMap<Integer, Employee>();
		Map<Employee, String> performanceMap = new HashMap<Employee, String>();

		boolean run = true;
		int choice;
		while (run) {
			choice = printMenuAndGetChoice(in);
			switch (choice) {
			case 1:
				addEmployee(employeeMap, performanceMap, in);
				break;
			case 2:
				removeEmployee(employeeMap, performanceMap, in);
				break;
			case 3:
				printPerformance(employeeMap, performanceMap, in);
				break;
			case 4:
				modifyPerformance(employeeMap, performanceMap, in);
				break;
			case 5:
				run = false;
				break;
			}
		}

	}

	public static int printMenuAndGetChoice(Scanner in) {
		boolean InvalidInput = true;
		int choice = 5;
		while (InvalidInput) {
			System.out.println("Press 1 to add an employee");
			System.out.println("Press 2 to remove an employee");
			System.out.println("Press 3 to print performance");
			System.out.println("Press 4 to modify performance");
			System.out.println("Press 5 to quit\n");
			try {
				choice = in.nextInt();
				InvalidInput = false;
			} catch (InputMismatchException ex) {
				System.out.println("-INVALID INPUT-\n");
				in.nextLine();
			}
		}
		return choice;
	}

	public static void addEmployee(Map<Integer, Employee> e, Map<Employee, String> ep, Scanner in) {
		System.out.println("Please enter the first name of the employee");
		in.nextLine();
		String first = in.nextLine();
		System.out.println("Please enter the last name of the employee");
		String last = in.nextLine();
		boolean checked = false;
		int ID = -1;
		while (!checked) {
			System.out.println("Please enter the ID number of the employee");
			try {
				ID = in.nextInt();
				if (e.containsKey(ID)) {
					System.out.println("An employee with that ID number already exists\n");
				} else
					checked = true;
			} catch (InputMismatchException ex) {
				System.out.println("-INVALID ENTRY-\n");
				in.nextLine();
			}
		}
		Employee newGuy = new Employee(first, last, ID);
		e.put(ID, newGuy);
		System.out.println("Please enter the performance of the employee");
		in.nextLine();
		ep.put(newGuy, in.nextLine());
	}

	public static void removeEmployee(Map<Integer, Employee> e, Map<Employee, String> ep, Scanner in) {
		System.out.println("Enter the ID number of the employee you wish to remove");
		int ID = in.nextInt();
		if (e.containsKey(ID)) {
			System.out.println("Removed " + e.get(ID).print() + "\n");
			e.remove(ID);
			ep.remove(e.get(ID));
		} else
			System.err.println("-ID number does not exist-\n");
	}

	public static void printPerformance(Map<Integer, Employee> e, Map<Employee, String> ep, Scanner in) {
		Set<Integer> fub = e.keySet();
		for (Integer i : fub) {
			System.out.println(e.get(i).print() + "Performance: " + ep.get(e.get(i)));
		}
		System.out.println();
	}

	public static void modifyPerformance(Map<Integer, Employee> e, Map<Employee, String> ep, Scanner in) {
		System.out.println("Please enter the ID number of the employee you wish to edit");
		int ID = in.nextInt();
		System.out.println("Please enter the performance update");
		String performance = in.nextLine();
		Employee guy = e.get(ID);
		ep.replace(guy, performance);
		System.out.println("Changed " + guy.print() + "performance to : " + performance + "\n");
	}
}