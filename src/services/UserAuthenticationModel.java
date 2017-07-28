package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DatabaseConnectionFactory;

public class UserAuthenticationModel {

	public static Boolean userAuthentication(String username, String password){
		
		return passwordAuth(password)&&userAuth((username));
	}
	
	private static Boolean passwordAuth(String password){
		
		
		Long passhash = null;
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select username from users where passwordHash = ?");
				st.setLong(1, password.hashCode());
				ResultSet rs = st.executeQuery();
				if(rs.next()&&rs!=null&&!rs.isClosed()){
					passhash = rs.getLong("passwordHash");
				}
			}
			catch(SQLException e){
				
			}
		}
				
		return passhash.equals(password.hashCode());
	}
	
	private static Boolean userAuth(String username){
		String usrnm = null;
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select username from users where username = ?");
				st.setString(1, username);
				ResultSet rs = st.executeQuery();
				if(rs.next()&&rs!=null&&!rs.isClosed()){
					 usrnm = rs.getString("username");
				}
			}
			catch(SQLException e){
				
			}
		}
		
		return usrnm.equals(username);
	}
}
