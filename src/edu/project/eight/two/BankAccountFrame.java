package edu.project.eight.two;

import javax.swing.JFrame;
/**
 * This is the main window
 * @author Alex Berthon
 *
 */
public class BankAccountFrame extends JFrame {

	public BankAccountFrame(BankAccount account) {
		setTitle("Bank Account");
		setBounds(267, 200, 425, 100);
		setResizable(false);
		this.add(new BankAccountPanel(account));
	}
}
