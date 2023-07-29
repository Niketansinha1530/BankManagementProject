package BankProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener {

	JTextField amount;
	JButton withdraw, back;
	String getPinNumber;

	Withdraw(String getPinNumber) {
		this.getPinNumber = getPinNumber;
		ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("BankProject/Atm-transformed.jpeg"));
		Image ii2 = ii.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon ii3 = new ImageIcon(ii2);
		JLabel imageJLabel = new JLabel(ii3);
		imageJLabel.setBounds(0, 0, 900, 800);
		add(imageJLabel);

		JLabel text = new JLabel("Enter the Amount you want to withdraw");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(200, 230, 350, 20);
		text.setForeground(Color.BLACK);
		imageJLabel.add(text);

		amount = new JTextField();
		amount.setBackground(Color.BLACK);
		amount.setFont(new Font("Raleway", Font.BOLD, 20));
		amount.setForeground(Color.WHITE);
		amount.setBounds(200, 280, 300, 30);
		imageJLabel.add(amount);

		withdraw = new JButton("Withdraw");
		withdraw.setBackground(Color.BLACK);
		withdraw.setForeground(Color.WHITE);
		withdraw.setFont(new Font("Raleway", Font.BOLD, 16));
		withdraw.setBounds(410, 440, 150, 30);
		withdraw.addActionListener(this);
		imageJLabel.add(withdraw);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setBounds(410, 480, 150, 30);
		back.addActionListener(this);
		imageJLabel.add(back);
		// Frame discription
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == withdraw) {

			String withdrawAmount = amount.getText();
			Date date = new Date();
			if (withdrawAmount.equals("")) {

				JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
			} else {
				try {

					Conn cn = new Conn();
					ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pin='" + getPinNumber + "'");
					int balance = 0;
					while (rs.next()) {// from this we get total balance in our account.
						if (rs.getString("type").equals("Deposite")) {
							balance += Integer.parseInt(rs.getString("amount"));
						} else {
							balance -= Integer.parseInt(rs.getString("amount"));
						}
					}

					if (balance < Integer.parseInt(withdrawAmount)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					
					String query = "INSERT INTO bank VALUES('" + getPinNumber + "','" + date + "','withdraw','"
							+ withdrawAmount + "')";
					cn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " Withdraw succesfully");
					amount.setText("");
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} else if (a.getSource() == back) {
			setVisible(false);
			new Transaction(getPinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {

		new Withdraw("");
	}
}
