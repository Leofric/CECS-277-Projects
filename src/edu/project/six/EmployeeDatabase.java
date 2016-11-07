package edu.project.six;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeDatabase {

	public static void main(String[] args) {
		Map<Integer, Employee> employeeMap = new TreeMap<Integer, Employee>();
		Map<Employee, String> performanceMap = new HashMap<Employee, String>();

		employeeMap.put(0, new Employee("bob", "dole", 0));
		performanceMap.put(employeeMap.get(0), "BAD");

		boolean run = true;
		int choice;
		while (run) {
			choice = printMenuAndGetChoice();
			switch (choice) {
			case 1:
				addEmployee(employeeMap, performanceMap);
				break;
			case 2:
				removeEmployee(employeeMap, performanceMap);
				break;
			case 3:
				printPerformance(employeeMap, performanceMap);
				break;
			case 4:
				modifyPerformance(employeeMap, performanceMap);
				break;
			case 5:
				run = false;
				break;
			}
		}

	}

	public static int printMenuAndGetChoice() {
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 to add an employee");
		System.out.println("Press 2 to remove an employee");
		System.out.println("Press 3 to print performance");
		System.out.println("Press 4 to modify performance");
		System.out.println("Press 5 to quit");
		int choice = in.nextInt();
		return choice;
	}

	public static void addEmployee(Map<Integer, Employee> e, Map<Employee, String> ep) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the first name of the employee");
		String first = in.nextLine();
		System.out.println("Please enter the last name of the employee");
		String last = in.nextLine();
		System.out.println("Please enter the ID number of the employee");
		int ID = in.nextInt();
		Employee newGuy = new Employee(first, last, ID);
		e.put(ID, newGuy);
		System.out.println("Please enter the performance of the employee");
		ep.put(newGuy, in.nextLine());		
	}

	public static void removeEmployee(Map<Integer, Employee> e, Map<Employee, String> ep) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the ID number of the employee you wish to remove");
		int ID = in.nextInt();
		e.remove(ID);
		ep.remove(e.get(ID));
		System.out.println("Removed " + e.get(ID).print());
		in.close();
	}

	public static void printPerformance(Map<Integer, Employee> e, Map<Employee, String> ep) {
		Set<Integer> fub = e.keySet();
		for (Integer i : fub) {
			System.out.println(e.get(i).print() + "Performance : " + ep.get(e.get(i)));
		}
	}

	public static void modifyPerformance(Map<Integer, Employee> e, Map<Employee, String> ep) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the ID number of the employee you wish to edit");
		int ID = in.nextInt();
		System.out.println("Please enter the performance update");
		String performance = in.nextLine();
		Employee guy = e.get(ID);
		ep.replace(guy, performance);
		System.out.println("Changed" + guy.print() + "performance to : " + performance);
		in.close();
	}
}