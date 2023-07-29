package BankProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.security.cert.TrustAnchor;
import java.sql.ResultSet;
import java.util.Date;//date package sql or util package dono may tho humay define karna hoga kiska date lay rahay hai

import javax.swing.*;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener {

	String getPinNumber;
	JButton depositeButton, withdrawButton, fastButton, miniButton, pinchangeButton, balanceButton, backButton;

	FastCash(String getPinNumber) {
		this.getPinNumber = getPinNumber;
		setLayout(null);
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));// image ki link
		Image ic2 = ic.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon ic3 = new ImageIcon(ic2);
		JLabel imageAtm = new JLabel(ic3);
		imageAtm.setBounds(0, 0, 900, 800);// image position set kar raha hu
		add(imageAtm);

		JLabel textLabel = new JLabel("Please Select the  withdrawl Option");
		textLabel.setBounds(200, 200, 700, 35);
		textLabel.setFont(new Font("System", Font.BOLD, 20));
		textLabel.setForeground(Color.BLACK);
		imageAtm.add(textLabel);// image kay upar text chaiya.

		// Button
		depositeButton = new JButton("Rs 100");
		depositeButton.setBounds(160, 345, 150, 30);
		depositeButton.setFont(new Font("Raleway", Font.BOLD, 16));
		depositeButton.setBackground(Color.BLACK);
		depositeButton.setForeground(Color.WHITE);
		depositeButton.addActionListener(this);
		imageAtm.add(depositeButton);

		withdrawButton = new JButton("Rs 200");
		withdrawButton.setBounds(420, 345, 150, 30);
		withdrawButton.setFont(new Font("Raleway", Font.BOLD, 16));
		withdrawButton.setBackground(Color.BLACK);
		withdrawButton.setForeground(Color.WHITE);
		withdrawButton.addActionListener(this);
		imageAtm.add(withdrawButton);

		fastButton = new JButton("Rs 500");
		fastButton.setBounds(160, 382, 150, 30);
		fastButton.setFont(new Font("Raleway", Font.BOLD, 16));
		fastButton.setBackground(Color.BLACK);
		fastButton.setForeground(Color.WHITE);
		fastButton.addActionListener(this);
		imageAtm.add(fastButton);

		miniButton = new JButton("Rs 1000");
		miniButton.setBounds(420, 382, 150, 30);
		miniButton.setFont(new Font("Raleway", Font.BOLD, 16));
		miniButton.setBackground(Color.BLACK);
		miniButton.setForeground(Color.WHITE);
		miniButton.addActionListener(this);
		imageAtm.add(miniButton);

		pinchangeButton = new JButton("Rs 2000");
		pinchangeButton.setBounds(160, 420, 150, 30);
		pinchangeButton.setFont(new Font("Raleway", Font.BOLD, 16));
		pinchangeButton.setBackground(Color.BLACK);
		pinchangeButton.setForeground(Color.WHITE);
		pinchangeButton.addActionListener(this);
		imageAtm.add(pinchangeButton);

		balanceButton = new JButton("Rs 5000");
		balanceButton.setBounds(420, 420, 150, 30);
		balanceButton.setFont(new Font("Raleway", Font.BOLD, 16));
		balanceButton.setBackground(Color.BLACK);
		balanceButton.setForeground(Color.WHITE);
		balanceButton.addActionListener(this);
		imageAtm.add(balanceButton);

		backButton = new JButton("BACK");
		backButton.setBounds(420, 457, 150, 30);
		backButton.setFont(new Font("Raleway", Font.BOLD, 16));
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(this);
		imageAtm.add(backButton);
		// Frame Discription.
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);// upar kay button invisible karta hai;
		setVisible(true);// Set visible hamesha last may hona chiaiya

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			setVisible(false);
			new Transaction(getPinNumber).setVisible(true);
		} else {
			// humaray pass sab hi amount kay button hai tho alag alag na bana kar hum sida
			// button se amount lay rahay hai or withdraw kar rahay hai.
			String amount = ((JButton) e.getSource()).getText().substring(3);// hum suru kay 3 charachter nahi chatay
																				// hai Rs 100;
			Conn cn = new Conn();
			try {

				ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pin='" + getPinNumber + "'");
				int balance = 0;
				while (rs.next()) {// from this we get total balance in our account.
					if (rs.getString("type").equals("Deposite")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (e.getSource() != backButton && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();// util package ka date hai.
				String query = "INSERT INTO bank VALUES ('" + getPinNumber + "','" + date + "','withdraw', '" + amount+ "')";
				cn.s.executeUpdate(query);
				JOptionPane.showInternalMessageDialog(null, "Rs" + amount + " Debited Succesfuly ");
				setVisible(false);
				new Transaction(getPinNumber).setVisible(true);
			} catch (Exception se) {
				System.out.println(se);
			}
		}
	}

	public static void main(String[] args) {
		new FastCash("");

	}

}
