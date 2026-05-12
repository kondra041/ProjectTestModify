package projectTestModify.bankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;
	public static Connection getConnection()
	{
		try {
			String mysqlJDBCDriver
				= "com.mysql.cj.jdbc.Driver"; //jdbc driver
			String url
				= "jdbc:mysql://localhost:3306/mydata"; //mysql url
			String user = "root";	 //mysql username
			String pass = "Pritesh4@"; //mysql passcode
			Class.forName(mysqlJDBCDriver);
			con = DriverManager.getConnection(url, user,
											pass);
		}
		catch (Exception e) {
			System.out.println("Connection Failed!");
		}

		return con;
	}
}
