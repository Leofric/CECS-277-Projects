package edu.project.two;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {
		// Staff
		Staff allen = new Staff(50.0, "Allen", "Paita", "123", "Male", new GregorianCalendar(1959, 2, 23));
		Staff zap = new Staff(35.0, "Zapada", "Steven", "456", "Female", new GregorianCalendar(1964, 7, 12));
		Staff rios = new Staff(40.0, "Rios", "Enrique", "789", "Male", new GregorianCalendar(1970, 6, 2));

		// faculty
		Faculty anne = new Faculty(new Education("ph.D", "Engineering", "3"), Faculty.Level.FU, "Anne", "Johnson",
				"243", "Female", new GregorianCalendar(1962, 4, 27));
		Faculty william = new Faculty(new Education("ph.D", "English", "1"), Faculty.Level.AS, "William", "Bouris",
				"791", "Female", new GregorianCalendar(1975, 3, 14));
		Faculty christopher = new Faculty(new Education("MS", "Physical Education", "0"), Faculty.Level.AO,
				"Christopher", "Andrade", "623", "Female", new GregorianCalendar(1980, 5, 22));

		// Part time
		Partime agusto = new Partime(30, 35, "Agusto", "Guzman", "455", "Female", new GregorianCalendar(1977, 8, 10));
		Partime martin = new Partime(15, 30, "Martin", "Depirro", "678", "Female", new GregorianCalendar(1987, 9, 15));
		Partime marque = new Partime(35, 20, "Marque", "Aldaco", "945", "Male", new GregorianCalendar(1988, 11, 24));

		Employee employees[] = new Employee[] { allen, zap, rios, anne, william, christopher, agusto, martin, marque };
		int total = 0;

		// Print in original order
		for (Employee e : employees) {
			System.out.println(e.toString() + "\n");
		}

		// print total for partime employees
		for (int i = 0; i < 9; i++) {
			Employee e = employees[i];
			if (e instanceof Partime) {
				total += employees[i].monthlyEarnings();
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println("Total partime monthly earnings $" + total);
		total = 0;

		// print earnings of all employees
		for (int i = 0; i < 9; i++) {
			total += employees[i].monthlyEarnings();
		}

		System.out.println("Total monthly earnings of all employees: $" + total + "\n");
		System.out.println("-----------------------------------------\n");


		// print all employees via id number
		Arrays.sort(employees);
		for (Employee e : employees) {
			System.out.println(e.toString() + "\n");
		}
		// print all employees via lastname
		System.out.println("_____________\n");

		Arrays.sort(employees, Employee.lastNameComparator);
		for (Employee e : employees) {
			System.out.println(e.toString() + "\n");
		}

		// duplicate a facultly object and verify it
		Faculty cloned = (Faculty) employees[6].clone();
		Faculty original = (Faculty)employees[6];
		original.setLevel(Faculty.Level.AO);
		
		System.out.println("**Original** \n" + employees[6].toString());
		
		System.out.println("\nCloned " + cloned.toString());

	}
}
