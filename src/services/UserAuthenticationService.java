package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DatabaseConnectionFactory;

public class UserAuthenticationService {
	private static final Object instance = new Object();
	
	protected UserAuthenticationService(){		
	}
	
	public static Object getInstance(){
		return instance;
	}

	public static Boolean isValidUser(String username, String password){
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		boolean authCheck = false;
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select * from users where username = ? and passwordHash= ?");	
				st.setString(1, username);
				st.setLong(2, password.hashCode());
				ResultSet rs = st.executeQuery();	
				
				if(rs.next() && !rs.isClosed()){				
					conn.close();
					authCheck = true;
				}else{
					conn.close();
					return false;
				}
			}
			catch(SQLException e){
				
			}
		}
		return authCheck;
	}
}
