package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Register here");
		System.out.println("Log in");
		int x;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		//objects
		Register_Project registerpojo = new Register_Project();
		RegisterDAO registerdao= new RegisterDAO();
		LoginPojo loginpojo = new LoginPojo();
		LoginDAO logindao = new LoginDAO();
		
		
		switch(x) {
		//for registration
		case 1:
			System.out.println("Enter your first name");
			String firstname = br.readLine();
			System.out.println("Enter your last name");
			String lastname = br.readLine();
			System.out.println("Enter user name");
			String username = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			System.out.println("Enter email");
			String email = br.readLine();
			
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(lastname);
			registerpojo.setUsername(username);
			registerpojo.setEmail(email);
			registerpojo.setPassword(password);
			
			registerdao.addUser(registerpojo);
			break;
			
		//for login	
		case 2: 
			System.out.println("Enter user name");
			String name = br.readLine();
			System.out.println("Enter password");
			String pass = br.readLine();
			
			loginpojo.setUsername(name);
			loginpojo.setPassword(pass);
			
			if(logindao.validate(loginpojo)==true)
			{
				Luck luck = new Luck();
				luck.display();
			}else
				System.out.println("Incorrect Username/ Password");
			
			break;
		}

	}

}
