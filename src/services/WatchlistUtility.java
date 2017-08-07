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
	 * @return Arraylist of watchlists
	 */
	
	@SuppressWarnings("unchecked")
	public static ArrayList<HashMap<String, Object>> editwatchlist(String username){
		
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
				  while (rs.next()){
				      
				     for(int i=1; i<=columns; ++i){           
				      list.add( (HashMap<String, Object>) new HashMap<String,Object>().put(md.getColumnName(i), rs.getString(i)));
				      
				     }
				      list.addAll(list);
				  }
			}
			catch(SQLException e){
				
			}
		}
		return list;
	}
	
	
}
