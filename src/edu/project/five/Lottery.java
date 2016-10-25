package edu.project.five;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {

	public static void main(String[] args) {
		Set<Integer> userTicket = new TreeSet<Integer>();
		Set<Integer> winningTicket = new TreeSet<Integer>();
		winningTicket = generateWinningNumbers();
		userTicket = getTicket();
		Iterator<Integer> it = userTicket.iterator();
		Iterator<Integer> wit = winningTicket.iterator();

		// print user ticket
		System.out.print("\nYour Ticket was [");
		for (int i = 0; i < 5; i++) {
			System.out.print(it.next() + ", ");
		}
		System.out.print(it.next() + "]\n");

		// print winning ticket
		System.out.print("\nWinning numbers [");
		for (int i = 0; i < 5; i++) {
			System.out.print(wit.next() + ", ");
		}
		System.out.print(wit.next() + "]\n");

		userTicket.retainAll(winningTicket);

		// print matches
		it = userTicket.iterator();
		if (userTicket.size() < 1) {
			System.out.println("Winning numbers []");
		} else if (userTicket.size() == 1) {
			System.out.println("Winning numbers [" + it.next() + "]");
		} else {
			System.out.print("\nWinning numbers [");
			for (int i = 0; i < userTicket.size() - 1; i++) {
				System.out.print(it.next() + ", ");
			}
			System.out.print(it.next() + "]\n");
		}
		double winnings = 250.00*userTicket.size();
		System.out.printf("Your prize is $%,.2f%n", winnings);
	}

	public static Set<Integer> generateWinningNumbers() {
		Set<Integer> WinningNumbers = new TreeSet<Integer>();
		Random rand = new Random();
		int randomIndex;
		boolean flag;
		while (WinningNumbers.size() < 6) {
			flag = false;
			randomIndex = rand.nextInt(40 + 1);
			for (Integer i : WinningNumbers) {
				if (randomIndex == i) {
					flag = true;
				}
			}
			if (!flag) {
				WinningNumbers.add(randomIndex);
			}
		}
		return WinningNumbers;
	}

	public static Set<Integer> getTicket() {
		Scanner in = new Scanner(System.in);
		Set<Integer> userTicket = new TreeSet<Integer>();

		System.out.println("Enter your 6 lotto numbers");
		for (int i = 0; i < 6; i++) {
			userTicket.add(in.nextInt());
		}
		in.close();
		return userTicket;
	}

}
