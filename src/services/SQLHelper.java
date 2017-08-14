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
	
	public static int editwatchlist(String symbols, String watchlistName, String username){
			
			java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
			PreparedStatement st = null;
			int rs=2;
			if(conn!=null){
				try{
					st = conn.prepareStatement("update watchlist w inner join users u on u.uid = w.uid SET stockSym = ? where u.username = ? and w.wl_name = ?");	
					st.setString(1, symbols);
					st.setString(2, username);
					st.setString(3,  watchlistName);
					rs = st.executeUpdate();
				} catch (SQLException e){
					System.out.println("Error updating the watchlist" + e.toString() );
				}
			}
			return rs;				
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
	
private static boolean doesWatchlistNameExist(String watchlistname){
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		boolean returnStatus = false;
		
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select wl_name from watchlist where wl_name = ?");	
				st.setString(1, watchlistname);
				ResultSet rs = st.executeQuery();
				if(rs.next()){
					conn.close();
					return true;
				}
				conn.close();
					
			}
			catch(SQLException e){
				System.out.println("Error processing watchlistname \n" + e.toString());
			}
		}
		return returnStatus;
		
		
	}
	
	public static boolean addWatchlist(String watchlist, String username, String watchlistname){
		
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		
		try{
			
			st = conn.prepareStatement("insert into watchlist (wl_name, stockSym, uid ) values (?, ?, (select uid from users where username = ?))");	
			st.setString(1, watchlistname);
			st.setString(2, watchlist);
			st.setString(3, username);
				
			if(doesWatchlistNameExist(watchlistname)){
				conn.close();
				return false;
				
			}else{
				st.executeUpdate();
			}			
			conn.close();					
		}
		catch(SQLException e){
			System.out.println("Error processing Create User Nice Try \n" + e.toString());
		}

		return true;
	}
	
	public static void removeWatchlist(String username, String watchlistname){
			
			
			java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
			PreparedStatement st = null;
			
			try{
				st = conn.prepareStatement("select WID from watchlist w inner join users u where u.username = ? and w.wl_name = ?");
				st.setString(1, username);
				st.setString(2, watchlistname);
				ResultSet r = st.executeQuery();
				int wlid = -1;
				
				while(r.next()){
					wlid = r.getInt("WID");
				}
				
				if(wlid != -1){
					st = conn.prepareStatement("delete from watchlist where WID = ?");	
					st.setInt(1, wlid);
					st.executeUpdate();
				}				
				conn.close();					
			}
			catch(SQLException e){
				System.out.println("Error processing removeWatchlist Nice Try \n" + e.toString());
			}
	}
}
