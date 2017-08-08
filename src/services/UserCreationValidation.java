package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DatabaseConnectionFactory;

public class UserCreationValidation {

/**
 * Takes in string username. tests if the username already exists in the database
 * 
 * @param username
 * @return boolean, if username exists returns true and user needs to try another username.
 */
	
public static boolean doesUsernameExist(String username){
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		boolean rs = false;
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select * from users where username = ?");	
				st.setString(1, username);
				rs = st.execute();	
				conn.close();
					
			}
			catch(SQLException e){
				
			}
		}
		return rs;
	}

public static boolean doesPwrdExist(String password){
	java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
	PreparedStatement st = null;
	boolean rs = false;
	if(conn!=null){
		try{
			st = conn.prepareStatement("Select * from users where password = ?");	
			st.setLong(1, password.hashCode());
			rs = st.execute();	
			conn.close();
				
		}
		catch(SQLException e){
			
		}
	}
	return rs;
}

public static int createNewUser(String username, String password, String email, String firstName, String lastName){
	java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
	PreparedStatement st = null;
	int rs = 2;
	if(conn!=null){
		try{
			st = conn.prepareStatement("Insert into users (username, passwordhash,first_name,last_name,email) values(?,?,?,?,?)");	
			st.setString(1, username);
			st.setLong(2, password.hashCode());
			st.setString(3, firstName);
			st.setString(4, lastName);
			st.setString(5, email);
			rs = st.executeUpdate();	
			conn.close();
				
		}
		catch(SQLException e){
			
		}
	}
	return rs;
}
}
