package BankProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener {

	JButton back;
	String pinNumber;
	int balance = 0;
	BalanceEnquiry( String pinNumber){
		this.pinNumber=pinNumber;
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));
		Image ic=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(ic);
		JLabel imageJLabel=new JLabel(icon2);
		add(imageJLabel);
		
		Conn c = new Conn();
		
		try {

			ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinNumber + "'");
			
			while (rs.next()) {// from this we get total balance in our account.
				if (rs.getString("type").equals("Deposite")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
			catch(Exception ess)
			{
				System.out.println(ess);
			}
		

		JLabel text=new JLabel("Your Current Account Balance is: "  + balance);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.BLACK);
		text.setBounds(170, 230, 350, 35);
		imageJLabel.add(text);
		
		
		back=new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(400, 477, 150, 35);
		back.setFont(new Font("Raleway",Font.BOLD,16));
		back.addActionListener(this);
		imageJLabel.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back);
		{
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
		
	}
	public static void main(String[] args) {

		new BalanceEnquiry("");
	}
	
}
