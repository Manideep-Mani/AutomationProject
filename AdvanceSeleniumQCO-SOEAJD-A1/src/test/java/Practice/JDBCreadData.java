package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Driver;

public class JDBCreadData {
public static void main(String[] args) throws Throwable {
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	java.sql.Statement stat = connection.createStatement();
	String query = "select * from student_info";
	ResultSet result = stat.executeQuery(query);
	while(result.next())
	{
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	}
connection.close();	
	
}
}
