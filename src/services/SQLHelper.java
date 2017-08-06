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
			System.out.println("Error processing Nice Try \n" + e.toString());
		}
		
		return watchLists;
	}
}
