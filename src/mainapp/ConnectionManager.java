package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//Register the driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create the connection object
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Subh#2410");
		
		if(con!=null)
			System.out.println("Established");
		return con;
	}
}
