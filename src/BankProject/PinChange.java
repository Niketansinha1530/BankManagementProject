package BankProject;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener {

	JPasswordField pintextfield,repintextfield;
	JButton changeButton,backButton;
	String pinnumber;
	PinChange(String pinNumber) {
		this.pinnumber=pinNumber;
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));
		Image ic=icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(ic);
		JLabel imageicon=new JLabel(icon2);
		add(imageicon);
		
		
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.BLACK);
		text.setFont(new Font("System",Font.BOLD,20));
		text.setBounds(270,170,300,35);
		imageicon.add(text);
		
		JLabel pintext=new JLabel("NEW PIN: ");
		pintext.setForeground(Color.BLACK);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(170,250,300,35);
		imageicon.add(pintext);
		
		pintextfield=new JPasswordField();
		pintextfield.setForeground(Color.WHITE);
		pintextfield.setFont(new Font("Raleway",Font.BOLD,16));
		pintextfield.setBounds(330,250,200,35);
		pintextfield.setBackground(Color.BLACK);
		imageicon.add(pintextfield);
		
		JLabel repintext=new JLabel("Re-Enter New PIN: ");
		repintext.setForeground(Color.BLACK);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(170,300,300,35);
		imageicon.add(repintext);
		
		repintextfield=new JPasswordField();
		repintextfield.setForeground(Color.WHITE);
		repintextfield.setFont(new Font("Raleway",Font.BOLD,16));
		repintextfield.setBounds(330,300,200,35);
		repintextfield.setBackground(Color.BLACK);
		imageicon.add(repintextfield);
		
		changeButton =new JButton("CHANGE");
		changeButton.setBackground(Color.BLACK);
		changeButton.setForeground(Color.WHITE);
		changeButton.setBounds(380, 445, 150, 35);
		changeButton.setFont(new Font("Raleway",Font.BOLD,16));
		changeButton.addActionListener(this);
		imageicon.add(changeButton);
		
		backButton =new JButton("BACK");
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.setBounds(380, 485, 150, 35);
		backButton.setFont(new Font("Raleway",Font.BOLD,16));
		backButton.addActionListener(this);
		imageicon.add(backButton);
		
		setSize(900, 900);
		setLocation(300, 0);
		//setUndecorated(true);
		setVisible(true);
		}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==changeButton)
		{
			try {
				String newpin=pintextfield.getText();
				String renewpin=repintextfield.getText();
				
				if(!newpin.equals(renewpin))
				{
					JOptionPane.showMessageDialog(null, "Entered pin is not Matched");
					return;
				}
				
				if(newpin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				if(renewpin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
					return;
				}
				
				Conn cn=new Conn();
				String query1="UPDATE bank SET pin= '"+newpin+"'WHERE pin='"+pinnumber+"'";
				String query2="UPDATE login SET pinnumber= '"+newpin+"'WHERE pinnumber='"+pinnumber+"'";
				String query3="UPDATE signupthree SET pinnumber= '"+newpin+"'WHERE pinnumber='"+pinnumber+"'";
				
				cn.s.executeUpdate(query1);
				cn.s.executeUpdate(query2);
				cn.s.executeUpdate(query3);
				
				JOptionPane.showInternalMessageDialog(null, "PIN changed successfully");
				
				setVisible(false);
				new Transaction(newpin).setVisible(true);
			}catch(Exception es)
			{
				System.out.println(es);
			}
			
		}else if(e.getSource()==backButton)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
			
		
	}
	public static void main(String[] args) {
		new PinChange("");
	}

	
}
