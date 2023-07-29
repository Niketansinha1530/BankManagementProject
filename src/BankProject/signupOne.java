package BankProject;

import java.awt.*;//color class 
import java.awt.event.*;

import javax.swing.*;//Jframe
import java.util.*;//Random
import com.toedter.calendar.*;
import com.toedter.calendar.demo.DateChooserPanel;

//jdatechooser jo hai wo (jcalendar jar) kay andar hota hai
public class signupOne extends JFrame implements ActionListener {

	long random;
	JTextField nameJTextField, fnameJTextField, emailJTextField, addressJTextField, cityJTextField, pinJTextField;
	JButton next;
	JDateChooser date;
	JRadioButton male, female, other, married, singal, other1;
	JComboBox stateJTextField;

	public signupOne() {

		setLayout(null);
		Random ran = new Random();
		random = Math.abs(ran.nextLong() % 9000L);// Math.abs no ko positive banyega.//ran.next(random no layega)
		JLabel formno = new JLabel("APPLICATION FORM NO." + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 40));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personalDetials = new JLabel("Page 1: Personal Details");
		personalDetials.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetials.setBounds(290, 80, 400, 30);
		add(personalDetials);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameJTextField = new JTextField();
		nameJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameJTextField.setBounds(300, 140, 300, 30);
		add(nameJTextField);

		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 150, 30);
		add(fname);

		fnameJTextField = new JTextField();
		fnameJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameJTextField.setBounds(300, 190, 300, 30);
		add(fnameJTextField);

		JLabel Dob = new JLabel("Date Of Birth:");
		Dob.setFont(new Font("Raleway", Font.BOLD, 20));
		Dob.setBounds(100, 240, 150, 30);
		add(Dob);

		date = new JDateChooser();
		date.setBounds(300, 240, 300, 30);
		date.setForeground(new Color(105, 10, 5, 105));
		add(date);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 150, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 80, 30);
		male.setBackground(Color.WHITE);
		add(male);

		female = new JRadioButton("Female");
		female.setBounds(400, 290, 80, 30);
		female.setBackground(Color.WHITE);
		add(female);

		other = new JRadioButton("Other");
		other.setBounds(500, 290, 80, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);

		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 150, 30);
		add(email);

		emailJTextField = new JTextField();
		emailJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailJTextField.setBounds(300, 340, 300, 30);
		add(emailJTextField);

		JLabel Marital = new JLabel("Marital Status:");
		Marital.setFont(new Font("Raleway", Font.BOLD, 20));
		Marital.setBounds(100, 390, 150, 30);
		add(Marital);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 80, 30);
		married.setBackground(Color.WHITE);
		add(married);

		singal = new JRadioButton("Singal");
		singal.setBounds(400, 390, 80, 30);
		singal.setBackground(Color.WHITE);
		add(singal);

		other1 = new JRadioButton("Other");
		other1.setBounds(500, 390, 80, 30);
		other1.setBackground(Color.WHITE);
		add(other1);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(singal);
		maritalGroup.add(other1);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 150, 30);
		add(address);

		addressJTextField = new JTextField();
		addressJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressJTextField.setBounds(300, 440, 300, 30);
		add(addressJTextField);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 490, 150, 30);
		add(state);

		String[] statesOfIndia = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
				"Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
				"Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
				"Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal",
				"Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu", "Lakshadweep",
				"Delhi", "Puducherry", "Ladakh", "Lakshadweep" };

		stateJTextField = new JComboBox(statesOfIndia);
		stateJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateJTextField.setBounds(300, 490, 300, 30);
		add(stateJTextField);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 540, 150, 30);
		add(city);

		cityJTextField = new JTextField();
		cityJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityJTextField.setBounds(300, 540, 300, 30);
		add(cityJTextField);

		JLabel pincode = new JLabel("PinCode:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 150, 30);
		add(pincode);

		pinJTextField = new JTextField();
		pinJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinJTextField.setBounds(300, 590, 300, 30);
		add(pinJTextField);

		next = new JButton("Next");
		next.setBounds(500, 640, 100, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);

		// PageDiscription
		setTitle("Signup Page");
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = "" + random;// converting long to string;
		String name = nameJTextField.getText();// gettext return name;
		String fname = fnameJTextField.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		} else if (other.isSelected()) {

			gender = "Other";
		}

		String email = emailJTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (singal.isSelected()) {
			marital = "Singal";
		} else if (other1.isSelected()) {
			marital = "Other";
		}
		String address = addressJTextField.getText();
		String city = cityJTextField.getText();
		String state = (String) stateJTextField.getSelectedItem();
		String pin = pinJTextField.getText();
		// dataBase is external entity so we need to handle the exception.
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");// validation khetay hai issay
			} else if (fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father's Name is Required");
			} else if (dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Date of Birth");
			} else if (city.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter city");
			} else {
				Conn c = new Conn();
				String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob
						+ "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','"
						+ state + "','" + pin + "')";
				c.s.executeUpdate(query);

				setVisible(false);
				new signupTwo(formno).setVisible(true);
			}
		} catch (Exception ea) {
			System.out.println(ea);
		}
	}

	public static void main(String[] args) {

		new signupOne();

	}
}
