package edu.project.six;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This Class allows the user to store employee objects, add, remove, edit, and
 * display employees and their performance
 * 
 * @author alexberthon
 *
 */
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

	/**
	 * This method prints the main menu and returns the users choice
	 * 
	 * @param in
	 *            The input scanner, type Scanner
	 * @return The option the user chose, type int
	 */
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

	/**
	 * This method adds an employee to both the employeeMap and Performance map
	 * 
	 * @param em
	 *            the map that stores the employee objects sorted by their id,
	 *            type Map<Integer, Employee>
	 * @param pm
	 *            the map that stores the employee and their performance, type
	 *            Map<Employee, String>
	 * @param in
	 *            the input scanner, type scanner
	 */
	public static void addEmployee(Map<Integer, Employee> em, Map<Employee, String> pm, Scanner in) {
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
				if (em.containsKey(ID)) {
					System.out.println("An employee with that ID number already exists\n");
				} else
					checked = true;
			} catch (InputMismatchException ex) {
				System.out.println("-INVALID ENTRY-\n");
				in.nextLine();
			}
		}
		Employee newGuy = new Employee(first, last, ID);
		em.put(ID, newGuy);

		checked = false;
		int choice = 0;
		while (!checked) {
			System.out.println("Please enter the performance of the employee\n");
			System.out.println(
					"Press 1 for Excellent\nPress 2 for Good\nPress 3 for Satisfactory\nPress 4 for Improvement\n");
			try {
				choice = in.nextInt();
				checked = true;
			} catch (InputMismatchException ab) {
				System.out.println("-Invalid Selection-\n");
			}
		}
		switch (choice) {
		case 1:
			pm.put(newGuy, "Excellent");
			break;
		case 2:
			pm.put(newGuy, "Good");
			break;
		case 3:
			pm.put(newGuy, "Satisfactory");
			break;
		case 4:
			pm.put(newGuy, "Improvement");
			break;
		}
		in.nextLine();
	}

	/**
	 * This method removes an employee from the employee map and performance map
	 * 
	 * @param em
	 *            the map that stores the employee objects sorted by their id,
	 *            type Map<Integer, Employee>
	 * @param pm
	 *            the map that stores the employee and their performance, type
	 *            Map<Employee, String>
	 * @param in
	 *            the input scanner, type scanner
	 */
	public static void removeEmployee(Map<Integer, Employee> em, Map<Employee, String> pm, Scanner in) {
		System.out.println("Enter the ID number of the employee you wish to remove");
		int ID = in.nextInt();
		if (em.containsKey(ID)) {
			System.out.println("Removed " + em.get(ID).print() + "\n");
			Employee temp = em.remove(ID);
			pm.remove(temp);
		} else
			System.err.println("-ID number does not exist-\n");
	}

	/**
	 * This method prints the employee and their performance sorted by the last
	 * name of the employee
	 * 
	 * @param em
	 *            the map that stores the employee objects sorted by their id,
	 *            type Map<Integer, Employee>
	 * @param pm
	 *            the map that stores the employee and their performance, type
	 *            Map<Employee, String>
	 * @param in
	 *            the input scanner, type scanner
	 */
	public static void printPerformance(Map<Integer, Employee> em, Map<Employee, String> pm, Scanner in) {
		Set<Employee> initial = pm.keySet();
		Set<Employee> sorted = new TreeSet<Employee>(initial);

		for (Employee a : sorted) {
			System.out.println(a.print() + " Performance: " + pm.get(a));
		}
		System.out.println();
	}

	/**
	 * This method modifies the performance of an employee
	 * 
	 * @param em
	 *            the map that stores the employee objects sorted by their id,
	 *            type Map<Integer, Employee>
	 * @param pm
	 *            the map that stores the employee and their performance, type
	 *            Map<Employee, String>
	 * @param in
	 *            the input scanner, type scanner
	 */
	public static void modifyPerformance(Map<Integer, Employee> em, Map<Employee, String> pm, Scanner in) {
		System.out.println("Please enter the ID number of the employee you wish to edit");
		boolean InvalidInput = true;
		int ID = 0;
		while (InvalidInput) {
			try {
				ID = in.nextInt();
				InvalidInput = false;
			} catch (InputMismatchException xd) {
				System.out.println("Employee ID number does not exist\n");
			}
			in.nextLine();
		}
		String performance = "";
		InvalidInput = true;
		int choice = 0;

		while (InvalidInput) {
			System.out.println("Please enter the performance update");
			System.out.println(
					"Press 1 for Excellent\nPress 2 for Good\nPress 3 for Satisfactory\nPress 4 for Improvement");
			try {
				choice = in.nextInt();
				InvalidInput = false;
			} catch (InputMismatchException ab) {
				System.out.println("-Invalid Selection-\n");
			}
		}
		switch (choice) {
		case 1:
			performance = "Excellent";
			break;
		case 2:
			performance = "Good";
			break;
		case 3:
			performance = "Satisfactory";
			break;
		case 4:
			performance = "Improvement";
			break;
		}
		in.nextLine();
		Employee guy = em.get(ID);
		pm.replace(guy, performance);
		System.out.println("Changed " + guy.print() + "performance to : " + performance + "\n");
	}
}