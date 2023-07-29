package BankProject;

import java.awt.*;//color class 
import java.awt.event.*;

import javax.swing.*;//Jframe
import java.util.*;//Random
import com.toedter.calendar.*;
import com.toedter.calendar.demo.DateChooserPanel;

//jdatechooser jo hai wo (jcalendar jar) kay andar hota hai
public class signupTwo extends JFrame implements ActionListener {

	JTextField aadharJTextField, panJTextField;
	JButton next;
	JComboBox religion,category ,income, education,occupation;
	JRadioButton syes, sno, eyes, eno;

	String formno;
	public signupTwo(String formno) {

		this.formno=formno;
		setLayout(null);
		JLabel additionalDetials = new JLabel("Additional Details");
		additionalDetials.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetials.setBounds(290, 80, 400, 30);
		add(additionalDetials);

		JLabel religiondetails = new JLabel("Religion:");
		religiondetails.setFont(new Font("Raleway", Font.BOLD, 20));
		religiondetails.setBounds(100, 140, 100, 30);
		add(religiondetails);

		String valreligion[] = { "", "Hindu", "Muslim", "Sikh", "Christian", "Other" };
		religion = new JComboBox(valreligion);
		religion.setFont(new Font("Raleway", Font.BOLD, 14));
		religion.setBackground(Color.WHITE);
		religion.setBounds(300, 140, 300, 30);
		add(religion);

		JLabel categorydetails = new JLabel("Category:");
		categorydetails.setFont(new Font("Raleway", Font.BOLD, 20));
		categorydetails.setBounds(100, 190, 150, 30);
		add(categorydetails);

		String valcategory[] = { "", "General", "OBC", "SC", "ST", "Other" };
		category = new JComboBox(valcategory);
		category.setFont(new Font("Raleway", Font.BOLD, 14));
		category.setBackground(Color.WHITE);
		category.setBounds(300, 190, 300, 30);
		add(category);

		JLabel incomedetails = new JLabel("Income:");
		incomedetails.setFont(new Font("Raleway", Font.BOLD, 20));
		incomedetails.setBounds(100, 240, 150, 30);
		add(incomedetails);

		String valincome[] = { "", "null", "<1,50,000", "<3,50,000", "<5,00,000", "Upto 10,00,000" };
		income = new JComboBox(valincome);
		income.setBackground(Color.WHITE);
		income.setFont(new Font("Raleway", Font.BOLD, 14));
		income.setBounds(300, 240, 300, 30);
		add(income);

		JLabel educationaldetails = new JLabel("Educational");
		educationaldetails.setFont(new Font("Raleway", Font.BOLD, 20));
		educationaldetails.setBounds(100, 290, 150, 30);
		add(educationaldetails);

		JLabel qualifictionaldetails = new JLabel("Qualification:");
		qualifictionaldetails.setFont(new Font("Raleway", Font.BOLD, 20));
		qualifictionaldetails.setBounds(100, 320, 150, 30);
		add(qualifictionaldetails);

		String educaationValue[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other" };
		education = new JComboBox(educaationValue);
		education.setFont(new Font("Raleway", Font.BOLD, 14));
		education.setBounds(300, 315, 300, 30);
		add(education);

		JLabel occupationdetails = new JLabel("Occupation:");
		occupationdetails.setFont(new Font("Raleway", Font.BOLD, 20));
		occupationdetails.setBounds(100, 390, 150, 30);
		add(occupationdetails);

		String occupationValue[] = { "Self-Employed", "Salaried", "Business", "Student", "Retired" };
		occupation = new JComboBox(occupationValue);
		occupation.setFont(new Font("Raleway", Font.BOLD, 14));
		occupation.setBounds(300, 390, 300, 30);
		add(occupation);

		JLabel pandetails = new JLabel("PAN:");
		pandetails.setFont(new Font("Raleway", Font.BOLD, 20));
		pandetails.setBounds(100, 440, 150, 30);
		add(pandetails);

		panJTextField = new JTextField();
		panJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panJTextField.setBounds(300, 440, 300, 30);
		add(panJTextField);

		JLabel aadharcarddetails = new JLabel("AADHAR NO:");
		aadharcarddetails.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharcarddetails.setBounds(100, 490, 150, 30);
		add(aadharcarddetails);

		aadharJTextField = new JTextField();
		aadharJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharJTextField.setBounds(300, 490, 300, 30);
		add(aadharJTextField);

		JLabel seniordetails= new JLabel("Senior Citizen:");
		seniordetails.setFont(new Font("Raleway", Font.BOLD, 20));
		seniordetails.setBounds(100, 540, 150, 30);
		add(seniordetails);

		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 80, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(400, 540, 80, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(syes);
		maritalGroup.add(sno);

		JLabel exisitingdetails = new JLabel("Exisiting Account:");
		exisitingdetails.setFont(new Font("Raleway", Font.BOLD, 20));
		exisitingdetails.setBounds(100, 590, 250, 30);
		add(exisitingdetails);

		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 80, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(400, 590, 80, 30);
		eno.setBackground(Color.WHITE);
		add(eno);

		ButtonGroup existinggroup = new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);

		next = new JButton("Next");
		next.setBounds(500, 640, 100, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);

		// PageDiscription
		setTitle("New Account Application Form Page No-2");
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sformno=formno;
		String sreligion = (String)religion.getSelectedItem();
		String scategory  = (String)category .getSelectedItem();
		String sincome= (String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		String ssenior = null;
		if (syes.isSelected()) {
			ssenior = "Yes";
		} else if (sno.isSelected()) {
			ssenior = "No";
		}
		String exisitingaccount = null;
		if (eyes.isSelected()) {
			exisitingaccount = "Yes";
		} else if (eno.isSelected()) {
			exisitingaccount = "No";
		}
		String aadhar_no = aadharJTextField.getText();
		String pan_no = panJTextField.getText();
		// dataBase is external entity so we need to handle the exception.
		try {
			if (aadhar_no.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Aadhar No");// validation khetay hai issay
			} else if (pan_no.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Pan Card No");
			}
		 else {
				Conn c = new Conn();
				String query = "INSERT INTO signupTwo VALUES('" + sformno + "','" + sreligion + "','" + scategory + "','" + sincome
						+ "','" + soccupation + "','" + seducation + "','" + ssenior + "','" + exisitingaccount + "','" +aadhar_no  + "','"
						+ pan_no + "')";
				c.s.executeUpdate(query);
				setVisible(false);
				new signupThree(sformno).setVisible(true);
			}
		} catch (Exception ea) {
			System.out.println(ea);
		}
	}

	public static void main(String[] args) {

		new signupTwo("");

	}

}
