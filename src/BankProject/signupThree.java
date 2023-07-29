package BankProject;
import java.awt.Color;
import java.util.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
public class signupThree  extends JFrame implements ActionListener{

	String sformno;
	JButton submit,cancel;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	public signupThree(String formno) {
		this.sformno=formno;
		setLayout(null);
		JLabel ll=new JLabel("Page 3: Account Details");
		ll.setFont(new Font("Raleway", Font.BOLD, 22));
		ll.setBounds(280,40,400,40);
		add(ll);
		
		JLabel acType=new JLabel("Account Type ");
		acType.setFont(new Font("Raleway", Font.BOLD, 22));
		acType.setBounds(100,110,200,60);
		add(acType);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,200,20);
		add(r1);
		
		r2=new JRadioButton("Current Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(400,180,200,20);
		add(r2);
		
		r3=new JRadioButton("Fixed Deposite Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,230,250,20);
		add(r3);
		
		r4=new JRadioButton("Recurring Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(400,230,200,20);
		add(r4);
		
		ButtonGroup acgroup=new ButtonGroup();
		acgroup.add(r1);
		acgroup.add(r2);
		acgroup.add(r3);
		acgroup.add(r4);
		
		JLabel cnNo=new JLabel("Card Number");
		cnNo.setFont(new Font("Raleway", Font.BOLD, 22));
		cnNo.setBounds(100,280,200,60);
		add(cnNo);
		
		JLabel number =new JLabel("XXXX-XXXX-XXXX-9560");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(300,280,300,60);
		add(number);
		
		JLabel details=new JLabel("Your 16 digit card Number");
		details.setFont(new Font("Raleway", Font.BOLD, 12));
		details.setBounds(100,300,200,60);
		add(details);
		
		JLabel pin=new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100,340,200,60);
		add(pin);
		
		JLabel pinnumber =new JLabel("XXXX");
		pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pinnumber.setBounds(300,340,100,60);
		add(pinnumber);
		
		JLabel pindetails=new JLabel("Your 4 digit Password");
		pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pindetails.setBounds(100,360,200,60);
		add(pindetails);
		
		JLabel serviceJLabel=new JLabel("Services Required:");
		serviceJLabel.setFont(new Font("Raleway", Font.BOLD, 22));
		serviceJLabel.setBounds(100,410,250,60);
		add(serviceJLabel);
		
		c1 =new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,480,200,30);
		add(c1);
		
		c2 =new JCheckBox("INTERNET BANKING");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(400,480,200,30);
		add(c2);
		
		c3 =new JCheckBox("MOBILE BANKING");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,530,200,30);
		add(c3);
		
		c4 =new JCheckBox("EAMIL & SMS ALERTS");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(400,530,200,30);
		add(c4);
		
		c5 =new JCheckBox("CHECK BOOK");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100,580,200,30);
		add(c5);
		
		c6 =new JCheckBox("E-STATEMENTS");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(400,580,200,30);
		add(c6);
		
		c7 =new JCheckBox("I hearby declared that the above entered details are correct to the best of my knowledge.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBounds(100,630,600,30);
		add(c7);
		
		submit =new JButton("Submit");
		submit.setBounds(100, 680, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel =new JButton("Cancel");
		cancel.setBounds(400, 680, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("New Account Application Form Page No-3");
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
			String Formno=sformno;
			String accounType=null;
			if(r1.isSelected())
			{
				accounType="Saving Account";
			}
			else if(r2.isSelected())
			{
				accounType="Current Account";
			}
			else if(r3.isSelected())
			{
				accounType="Fixed Deposite Account";
			}
			else if(r4.isSelected())
			{
				accounType="Recurring Account";
			}
			
			
			Random random=new Random();
			String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			
			String facility="";
			if(c1.isSelected())
			{
				facility=facility+" Atm card";
			}
			else if (c2.isSelected()) {
				facility=facility+" Internet Banking";
			}
			else if (c3.isSelected()) {
				facility=facility+" Email & Sms ";
			}
			else if (c4.isSelected()) {
				facility=facility+" Checqe book";
			}
			else if (c5.isSelected()) {
				facility=facility+" E-statement";
			}
			else if(c6.isSelected())
			{
				facility=facility+" Mobile banking";
			}

			try
			{
				if(accounType.equals(""))
				{
					JOptionPane.showInternalMessageDialog(null, "Account Type is Required");
				}
				else if(facility.equals(""))
				{
					JOptionPane.showInternalMessageDialog(null, "Select facility Please");
				}
				else {
					Conn conn = new Conn();
					String query1= "INSERT INTO signupthree VALUES('" + Formno + "','" + accounType + "','" + cardNumber + "','" + pinNumber +"','" + facility+"')";
					String query2= "INSERT INTO login VALUES('" + Formno + "','" + cardNumber + "','" + pinNumber +"')";

					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					JOptionPane.showInternalMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
					
					setVisible(false);
					new Deposite(pinNumber).setVisible(true);
				}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
	
		 new signupThree(" ");
	
	}

}
