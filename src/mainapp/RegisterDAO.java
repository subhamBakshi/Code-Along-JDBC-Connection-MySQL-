package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void addUser(Register_Project registerpojo) throws ClassNotFoundException, SQLException {
		String firstname = registerpojo.getFirstname();
		String lastname = registerpojo.getLastname();
		String username = registerpojo.getUsername();
		String password = registerpojo.getPassword();
		String email = registerpojo.getEmail();
				
		ConnectionManager cm = new ConnectionManager();
	
		//Insert all the details into Database
		String sql = "insert into USERDETAILS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL)VALUES(?,?,?,?,?)";
		//Create Statement object
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setNString(1, firstname);
		st.setNString(2, lastname);
		st.setNString(3, username);
		st.setNString(4, password);
		st.setNString(5, email);
		
		//Executing the Statement
		st.executeLargeUpdate();
		//Close the connection
		cm.getConnection().close();
	}
	
}
