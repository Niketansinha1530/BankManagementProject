package BankProject;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;
public class miniStatement extends JFrame {

	miniStatement( String pinNumber)
	{
		setLayout(null);
		
		JLabel mini=new JLabel();
		mini.setBounds(20, 140, 300, 200);
		add(mini);
		
		JLabel nametext=new JLabel("Bharat Bank");
		nametext.setBounds(130, 15, 150, 35);
		nametext.setFont(new Font("System",Font.BOLD,18));
		add(nametext);
		
		JLabel cardno=new JLabel();//dynamicaly allocate
		cardno.setFont(new Font("System",Font.BOLD,16));
		cardno.setBounds(20, 80, 300, 20);
		add(cardno);
		
		JLabel balanceJLabel =new JLabel();
		balanceJLabel.setFont(new Font("System",Font.BOLD,16));
		balanceJLabel.setBounds(20, 450, 300, 30);
		add(balanceJLabel);
		try
		{
		Conn conn=new Conn();
		ResultSet rs=conn.s.executeQuery("SELECT * FROM login WHERE pinnumber = '"+pinNumber+"'");//jaha pay ya pin number match kar raha waha se laytay aoo data
		while(rs.next())
		{
			cardno.setText("Card No: " + rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+rs.getString("cardnumber").substring(12));
		}
		}catch(Exception except)
		{
			System.out.println(except);
		}
		
		try
		{
			Conn conn=new Conn();
			int balance = 0;
			ResultSet rs1=conn.s.executeQuery("SELECT * FROM bank WHERE pin='"+pinNumber+"'");
			while(rs1.next())//iski help se hum database se value lay ayenay or paste karsactay hai 
			{
			  mini.setText(mini.getText()+"<html>"+ rs1.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs1.getString("amount")+"<br><br>"+"<html>");
			  if (rs1.getString("type").equals("Deposite")) {
			    balance += Integer.parseInt(rs1.getString("amount"));
			  } else {
			    balance -= Integer.parseInt(rs1.getString("amount"));
			  }
			}
			balanceJLabel.setText("Your account balance is  Rs "+balance);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		setSize(400,600);
		setLocation(40,40);
		getContentPane().setBackground(Color.white);
		setTitle("Mini Statement");
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new miniStatement("");
	}
}
