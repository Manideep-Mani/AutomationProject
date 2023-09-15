package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCwriteData {
public static void main(String[] args) throws Throwable {
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	Statement stat = connection.createStatement();
	String query = "insert into student_info(first_name,last_name,address)values('Abhi','ch','Hyderabad')";
	int result = stat.executeUpdate(query);
	
	if(result==1)
	{
		System.out.println("data updated");
	}
	else
	{
		System.out.println("data not updated");
	}
	
}
}
