package services;

import model.WatchListBean;

public class WatchListParserService {
	private static final Object instance = new Object();
	
	protected WatchListParserService (){
		
	}
	public static Object getInstance(){
		return instance;
	}
	
	public static String watchListAdd(String sym, WatchListBean watchlist){
		StringBuilder sb = new StringBuilder();
		sb.append(watchlist.getWatchlist() + "," + sym);		
		return sb.toString();
	}
	
	public static String watchListRemove(String sym, WatchListBean watchlist){
		StringBuilder sb = new StringBuilder();
		String[] syms = watchlist.getWatchlist().split(",");

		for(String s : syms){
			if(!s.equals(sym)){
				sb.append(s +",");

			}
		}
		sb.deleteCharAt(sb.length() - 1);				
		return sb.toString();
	}	
	
	public static String removeSymbol(String sym, String watchlist){
		StringBuilder sb = new StringBuilder();
		String[] syms = watchlist.split(",");

		for(String s : syms){
			if(!s.equals(sym)){
				sb.append(s +",");

			}
		}
		sb.deleteCharAt(sb.length() - 1);				
		return sb.toString();
	}
	
	public static String watchListAdd(String sym, String watchlist){
		StringBuilder sb = new StringBuilder();
		sb.append(watchlist + "," + sym);		
		return sb.toString();
	}
}
