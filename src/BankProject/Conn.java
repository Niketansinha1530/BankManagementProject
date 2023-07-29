package BankProject;
//now making database connectivity
//abb hum connection kareyengay jdbc ka or signupOne page ka.
//5step follow kartay hai
//1.Register the driver.//no need to register driver only give url,user name,password.
//2.create connection.
//3.Create Statement.
//4.execute query.
//5.Close connection.
import java.sql.*;
public class Conn {

	Connection c;
	Statement s; 
	Conn()
	{
		try
		{
			
			c=DriverManager.getConnection("jdbc:postgresql://localhost/bankmanagement","postgres","Niketan@1530");//database_name,konsa database,password.
			s=c.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
