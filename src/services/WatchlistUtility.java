package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.DatabaseConnectionFactory;

public class WatchlistUtility {

	/**
	 * Returns Arraylist<Hashmap<String"watchlistname",Object"watchliststring">> of all watchlists associated with a specific user. 
	 * @param username
	 * @return Arraylist
	 */
	
	@SuppressWarnings("unchecked")
	public static ArrayList<HashMap<String, Object>> getwatchlist(String username){
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		if(conn!=null){
			try{
				st = conn.prepareStatement("Select * from watchlist inner join users on users.uid = watchlist.uid"
						+ "where username = ?");	
				st.setString(1, username);
				ResultSet rs = st.executeQuery();	
				ResultSetMetaData md = rs.getMetaData();
				  int columns = md.getColumnCount();
				  list = new ArrayList <HashMap<String,Object>>(columns);
				
				      
				     for(int i=1; i<=columns; ++i){           
				      list.add( (HashMap<String, Object>) new HashMap<String,Object>().put(md.getColumnName(i), rs.getString(i)));
				      
				     }
				      
				  
			}
			catch(SQLException e){
				
			}
		}
		return list;
	}
	
	/**
	 * takes the watchlist
	 * @param watchlist
	 * @param username
	 * @return
	 */
	
	public static int editwatchlist(String watchlist, String watchlistName){
		
		java.sql.Connection conn = DatabaseConnectionFactory.getInstance().getDatabaseConnection() ;
		PreparedStatement st = null;
		int rs=2;
		if(conn!=null){
			try{
				st = conn.prepareStatement("Update watchlist inner join users on users.uid = watchlist.uid"
						+ "set stockSym.watchlist = ? where wl_name = ?");	
				st.setString(1, watchlist);
				st.setString(2, watchlistName);
				rs = st.executeUpdate();	

				
				
			}
			catch(SQLException e){
				
			}
		}
		
	return rs;
	}
	
	
	
}
