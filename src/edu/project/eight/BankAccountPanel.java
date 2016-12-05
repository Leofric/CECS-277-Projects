package edu.project.eight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the panel that is on the main window, contains text boxes, buttons,
 * text, etc.
 * 
 * @author Alex Berthon
 *
 */
public class BankAccountPanel extends JPanel implements ActionListener {

	private JButton withdrawlButton, depositButton;
	private JLabel amount, balance;
	private JTextField amountField;
	private JLabel errorMessage;
	private edu.project.eight.BankAccount account;

	public BankAccountPanel(edu.project.eight.BankAccount account) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.account = account;
		amount = new JLabel("Amount");
		this.add(amount);

		amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(100, 25));
		this.add(amountField);

		withdrawlButton = new JButton("Withdrawl");
		withdrawlButton.addActionListener(this);
		this.add(withdrawlButton);

		depositButton = new JButton("Deposit");
		depositButton.addActionListener(this);
		this.add(depositButton);

		balance = new JLabel("Balance: " + account.getBalance());
		this.add(balance);

		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		this.add(errorMessage);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == withdrawlButton) {
			try {
				double amount = Double.parseDouble(amountField.getText());
				if (account.getBalance() >= amount && amount > 0) {
					account.withdraw(amount);
					balance.setText("Balance: " + account.getBalance());
					errorMessage.setText("");
				} else if (amount < 0) {
					errorMessage.setText("Input must be positive");
				} else {
					errorMessage.setText("Not enough money in your account");
				}
			} catch (NumberFormatException x) {
				errorMessage.setText("Invalid Input");
			}
		}

		else if (source == depositButton) {
			try {
				double amount = Double.parseDouble(amountField.getText());
				if (amount > 0) {
					account.deposit(amount);
					balance.setText("Balance: " + account.getBalance());
					errorMessage.setText("");
				} else {
					errorMessage.setText("Input must be positive");
				}
			} catch (NumberFormatException x) {
				errorMessage.setText("Invalid Input");
			}
		}
	}
}
