package BankProject;
import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;//ActionListener.
import java.sql.ResultSet;//Resultset ka use kar rahay hai

public class Login extends JFrame implements ActionListener {

	JButton clear, signin, signup;// hum in button ko global use karna chata hai isliya hum issay bharr declare
									// kar rahay hai iska use kar sackkay.or whaa se initialisation hata rahay hai

	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login() {
		setTitle("Automated Teller Machine");

		setLayout(null);// by default image hamesha centre may rheti tho issay "null" karna padtta hai
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("BankProject/SL-020622-4930-14.jpg"));
		Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);// image ki size ko adjust  karna hai;
																				
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);// image ko hum Jlabel may direct nahi dalsactay hai.
		label.setBounds(70, 20, 100, 100);// left se margin,top se margin,and then size of image
		add(label);// image frame pay paste karta hai "add".

		// background color frame
		getContentPane().setBackground(Color.WHITE);

		// text on frame
		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("System", Font.BOLD, 40));// text font,style,size of font.
		text.setForeground(new Color(135,206,235));
		text.setBounds(220, 40, 400, 40);// position of text//left se right se then, length of text and then height
		add(text);

		JLabel Cardno = new JLabel("Card No:");
		Cardno.setFont(new Font("Raleway", Font.CENTER_BASELINE, 28));
		Cardno.setBounds(120, 150, 150, 30);// position of text//left se right se then, length of text and then height
		add(Cardno);
		
		// field area jaha pay hum card no likheyngay.//yaha password dalna hai tho *****
		cardTextField = new JTextField();
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		cardTextField.setBounds(300, 150, 230, 30);
		add(cardTextField);

		//Text pin
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway", Font.CENTER_BASELINE, 28));
		pin.setBounds(120, 220, 150, 30);// position of text//left se right se then, length of text and then height
		add(pin);
		// field area jaha pay hum pin no likheyngay.
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);

		// now built button.
		signin = new JButton("SIGN IN");
		signin.setBounds(300, 280, 100, 30);// Button position
		signin.setBackground(new Color(169,169,169));
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);

		clear = new JButton("CLEAR");
		clear.setBounds(430, 280, 100, 30);
		clear.setBackground(new Color(169,169,169));
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);

		signup = new JButton("SIGN UP");
		signup.setBounds(300, 330, 230, 30);
		signup.setBackground(new Color(169,169,169));
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);

		// FrameDiscription
		setSize(800, 440);
		setLocation(350, 200);// from the origin./from left,top
		setVisible(true);//set Visible hamesha last may hona chiaya.
	}

	//action add on buttons.
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clear) {

		cardTextField.setText("");
		pinTextField.setText("");
		} else if (e.getSource() == signin) {

			Conn conn=new Conn();
			String getcardNumber=cardTextField.getText();
			String getPinNumber=pinTextField.getText();
			String query="SELECT * FROM login WHERE cardNumber='"+getcardNumber+"' AND pinNumber ='"+getPinNumber+"'";//comaring through database.
			//Database se comparison kar rahay hai.
			try
			{
				ResultSet rn=conn.s.executeQuery(query);//iska return type resultset hota hai.//jdbc working.
				if(rn.next())//data correct hua tho if part execute hoga warna else part.
				{
					setVisible(false);
					new Transaction(getPinNumber).setVisible(true);	
				}
				else if(getcardNumber.equals("")&&getPinNumber.equals(""))
				{
					JOptionPane.showInternalMessageDialog(null, "Please enter CardNumber And pinNumber");
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "Incorrect CardNumber or Pin");
				}
				
			}catch(Exception es)
			{
				System.out.println(es);
			}
			
		} else if (e.getSource() == signup) {
			setVisible(false);
			new signupOne().setVisible(true);

		}
	}

	public static void main(String[] args) {
		new Login();

	}
}
