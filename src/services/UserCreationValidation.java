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
	
public static Boolean doesUsernameExist(String username){
		
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
}
