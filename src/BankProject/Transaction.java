package BankProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.security.cert.TrustAnchor;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

	String getPinNumber;
	JButton depositeButton,withdrawButton,fastButton,miniButton,pinchangeButton,balanceButton,exitceButton;
	Transaction( String getPinNumber) {
		this.getPinNumber=getPinNumber;
		setLayout(null);
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));// image ki link
		Image ic2 = ic.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon ic3 = new ImageIcon(ic2);
		JLabel imageAtm = new JLabel(ic3);
		imageAtm.setBounds(0, 0, 900, 800);// image position set kar raha hu
		add(imageAtm);

		JLabel textLabel = new JLabel("Please Select the  Option");
		textLabel.setBounds(250, 200, 700, 35);
		textLabel.setFont(new Font("System", Font.BOLD, 20));
		textLabel.setForeground(Color.BLACK);
		imageAtm.add(textLabel);// image kay upar text chaiya.

		// Button
		depositeButton = new JButton("Deposite");
		depositeButton.setBounds(160, 345, 150, 30);
		depositeButton.setFont(new Font("Raleway", Font.BOLD, 16));
		depositeButton.setBackground(Color.BLACK);
		depositeButton.setForeground(Color.WHITE);
		depositeButton.addActionListener(this);
		imageAtm.add(depositeButton);

		withdrawButton = new JButton(" Cash withdraw");
		withdrawButton.setBounds(420, 345, 150, 30);
		withdrawButton.setFont(new Font("Raleway", Font.BOLD, 16));
		withdrawButton.setBackground(Color.BLACK);
		withdrawButton.setForeground(Color.WHITE);
		withdrawButton.addActionListener(this);
		imageAtm.add(withdrawButton);

		fastButton = new JButton("Fast Cash");
		fastButton.setBounds(160, 382, 150, 30);
		fastButton.setFont(new Font("Raleway", Font.BOLD, 16));
		fastButton.setBackground(Color.BLACK);
		fastButton.setForeground(Color.WHITE);
		fastButton.addActionListener(this);
		imageAtm.add(fastButton);

		miniButton = new JButton("Mini Statement");
		miniButton.setBounds(420, 382, 150, 30);
		miniButton.setFont(new Font("Raleway", Font.BOLD, 16));
		miniButton.setBackground(Color.BLACK);
		miniButton.setForeground(Color.WHITE);
		miniButton.addActionListener(this);
		imageAtm.add(miniButton);

		pinchangeButton = new JButton("Pin Change");
		pinchangeButton.setBounds(160, 420, 150, 30);
		pinchangeButton.setFont(new Font("Raleway", Font.BOLD, 16));
		pinchangeButton.setBackground(Color.BLACK);
		pinchangeButton.setForeground(Color.WHITE);
		pinchangeButton.addActionListener(this);
		imageAtm.add(pinchangeButton);

		balanceButton = new JButton("Balance Enq");
		balanceButton.setBounds(420, 420, 150, 30);
		balanceButton.setFont(new Font("Raleway", Font.BOLD, 16));
		balanceButton.setBackground(Color.BLACK);
		balanceButton.setForeground(Color.WHITE);
		balanceButton.addActionListener(this);
		imageAtm.add(balanceButton);

		exitceButton = new JButton("Exit");
		exitceButton.setBounds(420, 457, 150, 30);
		exitceButton.setFont(new Font("Raleway", Font.BOLD, 16));
		exitceButton.setBackground(Color.BLACK);
		exitceButton.setForeground(Color.WHITE);
		exitceButton.addActionListener(this);
		imageAtm.add(exitceButton);
		// Frame Discription.
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);//upar kay button invisible karta hai;
		setVisible(true);// Set visible hamesha last may hona chiaiya

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitceButton)
		{
			System.exit(0);
		}else if(e.getSource()==depositeButton)
		{
			setVisible(false);
			new Deposite(getPinNumber).setVisible(true);
		}
		else if(e.getSource()==withdrawButton)
		{
			setVisible(false);
			new Withdraw(getPinNumber).setVisible(true);
		}else if(e.getSource()==fastButton)
		{
			setVisible(false);
			new FastCash(getPinNumber).setVisible(true);
		}
		else if(e.getSource()==pinchangeButton)
		{
			setVisible(false);
			new PinChange(getPinNumber).setVisible(true);
		}
		else if(e.getSource()==balanceButton)
		{
			setVisible(false);
			new BalanceEnquiry(getPinNumber).setVisible(true);
		}
		else if(e.getSource()==miniButton)
		{
		
			new miniStatement(getPinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transaction("");

	}

}
