package services;

import model.WatchListBean;

public class WatchListParserService {
	private static final Object instance = new Object();
	
	protected WatchListParserService (){		
	}
	public static Object getInstance(){
		return instance;
	}
	
	public static String watchListAdd(String sym, WatchListBean watchList){
		StringBuilder sb = new StringBuilder();
		sb.append(watchList.getWatchlist() + "," + sym);		
		return sb.toString();
	}
	
	public static String watchListRemove(String sym, WatchListBean watchList){
		StringBuilder sb = new StringBuilder();
		String[] syms = watchList.getWatchlist().split(",");

		for(String s : syms){
			if(!s.equals(sym)){
				sb.append(s +",");
			}
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length() - 1);
		}
						
		return sb.toString();
	}	
	
	public static String removeSymbol(String sym, String watchList){
		StringBuilder sb = new StringBuilder();
		String[] syms = watchList.split(",");

		for(String s : syms){
			s = s.trim();
			if(!s.equals(sym)){
				sb.append(s +",");
			}
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length() - 1);
		}			
		return sb.toString();
	}
	
	public static String addSymbol(String sym, String watchList){
		StringBuilder sb = new StringBuilder();
		if(watchList.length() != 0){
			sb.append(watchList + "," + sym);
		}else{
			sb.append(sym);
		}			
		return sb.toString();
	}
}
