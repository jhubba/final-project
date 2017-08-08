package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnectionFactory;
import model.WatchListBean;

public class SQLHelper {
	private static final Object instance = new Object();
	
	protected SQLHelper (){
		
	}
	public static Object getInstance(){
		return instance;
	}
	
	public static List<WatchListBean> getUserWatchLists(String username){
		List<WatchListBean> watchLists = new ArrayList<>();
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		
		try{
			
			st = conn.prepareStatement("SELECT * FROM watchlist w INNER JOIN  users u on u.uid = w.uid where u.username = ?");	
			st.setString(1, username);			
			ResultSet rs = st.executeQuery();	
			
			while(rs.next()){				
				WatchListBean wb = new WatchListBean();
				wb.setWatchListName(rs.getString("wl_name"));
				wb.setWatchlist(rs.getString("stockSym"));
				watchLists.add(wb);
			}		
			conn.close();					
		}
		catch(SQLException e){
			System.out.println("Error processing getUserWatchLists Nice Try \n" + e.toString());
		}
		
		return watchLists;
	}
	
	public static boolean createUser(String username, String password, String firstname, String lastname, String email){
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		
		try{
			
			st = conn.prepareStatement("insert into users (username, passwordHash, first_name, last_name, email) values (?, ?, ?, ?, ?)");	
			st.setString(1, username);
			st.setInt(2, password.hashCode());
			st.setString(3, firstname);
			st.setString(4, lastname);
			st.setString(5, email);
			st.executeUpdate();	
			if(doesUsernameExist(username)){
				conn.close();
				return true;
				
			}	
			conn.close();					
		}
		catch(SQLException e){
			System.out.println("Error processing Create User Nice Try \n" + e.toString());
		}

		return false;
	}
	public static boolean doesUsernameExist(String username){		
			java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
			PreparedStatement st = null;
			boolean returnStatus = false;
			
			if(conn!=null){
				try{
					st = conn.prepareStatement("Select * from users where username = ?");	
					st.setString(1, username);
					ResultSet rs = st.executeQuery();
					if(rs.next()){
						conn.close();
						return true;
					}
					conn.close();
						
				}
				catch(SQLException e){
					System.out.println("Error processing doesUsernameExist Nice Try \n" + e.toString());
				}
			}
			return returnStatus;
		}
}
