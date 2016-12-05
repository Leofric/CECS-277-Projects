package edu.project.eight.two;

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
public class BankAccountPanel extends JPanel{

	protected JButton withdrawlButton;
	protected JButton depositButton;
	protected JLabel amount, balance;
	protected JTextField amountField;
	protected JLabel errorMessage;
	protected BankAccount account;

	public BankAccountPanel(BankAccount account) {
		ActionListener listener = new BankAccountButtonListener(this, account);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.account = account;
		amount = new JLabel("Amount");
		this.add(amount);

		amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(100, 25));
		this.add(amountField);

		withdrawlButton = new JButton("Withdrawl");
		withdrawlButton.addActionListener(listener);
		this.add(withdrawlButton);

		depositButton = new JButton("Deposit");
		depositButton.addActionListener(listener);
		this.add(depositButton);

		balance = new JLabel("Balance: " + account.getBalance());
		this.add(balance);

		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		this.add(errorMessage);
	}
}