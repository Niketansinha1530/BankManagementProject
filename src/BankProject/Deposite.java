package BankProject;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposite extends JFrame  implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String getPinNumber;
	Deposite(String getPinNumber)
	{
		this.getPinNumber=getPinNumber;
		ImageIcon ii=new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));
		Image ii2= ii.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon ii3=new ImageIcon(ii2);
		JLabel imageJLabel=new JLabel(ii3);
		imageJLabel.setBounds(0, 0, 900,800);
		add(imageJLabel);
		
		JLabel text=new JLabel("Enter the Amount you want to Deposite");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(200,230,350,20);
		text.setForeground(Color.BLACK);
		imageJLabel.add(text);
		
		amount=new JTextField();
		amount.setBackground(Color.BLACK);
		amount.setFont(new Font("Raleway",Font.BOLD,20));
		amount.setForeground(Color.WHITE);
		amount.setBounds(200, 280, 300, 30);
		imageJLabel.add(amount);
		
		deposit=new JButton("Deposite");
		deposit.setBackground(Color.BLACK);
		deposit.setForeground(Color.WHITE);
		deposit.setFont(new Font("Raleway",Font.BOLD,16));
		deposit.setBounds(410, 440, 150, 30);
		deposit.addActionListener(this);
		imageJLabel.add(deposit);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Raleway",Font.BOLD,16));
		back.setBounds(410, 480, 150, 30);
		back.addActionListener(this);
		imageJLabel.add(back);
		//Frame discription
		setSize(900,900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==deposit)
		{
		
			Date date=new Date();
			String depoistAmount=amount.getText();
			if(depoistAmount.equals(""))
			{
				JOptionPane.showInternalConfirmDialog(null, "Please enter deposite Amount");
			}
			try
			{
				Conn cn=new Conn();
				String query="INSERT INTO bank VALUES('"+getPinNumber+"','"+date+"','Deposite','"+depoistAmount+"')";
				cn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+depoistAmount+"Deposited succesfully");
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}else if(a.getSource()==back)
		{
			setVisible(false);
			new Transaction(getPinNumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		
		new Deposite("");
	}

}
