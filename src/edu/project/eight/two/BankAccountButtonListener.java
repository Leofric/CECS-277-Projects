package edu.project.eight.two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountButtonListener implements ActionListener {
	private BankAccountPanel panel;
	private BankAccount account;

	public BankAccountButtonListener(BankAccountPanel panel, BankAccount account) {
		this.panel = panel;
		this.account = account;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == panel.withdrawlButton) {
			try {
				double amount = Double.parseDouble(panel.amountField.getText());
				if (account.getBalance() >= amount && amount > 0) {
					account.withdraw(amount);
					panel.balance.setText("Balance: " + account.getBalance());
					panel.errorMessage.setText("");
				} else if (amount < 0) {
					panel.errorMessage.setText("Input must be positive");
				} else {
					panel.errorMessage.setText("Not enough money in your account");
				}
			} catch (NumberFormatException x) {
				panel.errorMessage.setText("Invalid Input");
			}
		}

		else if (source == panel.depositButton) {
			try {
				double amount = Double.parseDouble(panel.amountField.getText());
				if (amount > 0) {
					account.deposit(amount);
					panel.balance.setText("Balance: " + account.getBalance());
					panel.errorMessage.setText("");
				} else {
					panel.errorMessage.setText("Input must be positive");
				}
			} catch (NumberFormatException x) {
				panel.errorMessage.setText("Invalid Input");
			}
		}
	}
}