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

	public static Boolean userAuthentication(String username, String password){
		return passwordAuth(password)&&userAuth((username));
	}
	
	private static Boolean passwordAuth(String password){
			
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		boolean authCheck = false;
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select username from users where passwordHash = ?");
				st.setLong(1, password.hashCode());
				ResultSet rs = st.executeQuery();	
				
				if(rs.next() && rs!=null && !rs.isClosed()){				
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
				conn.close();
			}
			catch(SQLException e){				
			}
		}
		
		return usrnm.equals(username);
	}
}
