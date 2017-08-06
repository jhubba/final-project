package services;

import java.util.ArrayList;

import model.QueryHelper;
import model.QueryResult;
import model.Result;
import model.WatchListQuoteBean;
import model.WatchListQuoteHolderBean;

public class WatchListSymbolHelper {
private static final Object instance = new Object();
	
	protected WatchListSymbolHelper (){
		
	}
	public static Object getInstance(){
		return instance;
	}
			
	public static WatchListQuoteHolderBean getSym(String watchListSymbols) {
		WatchListQuoteHolderBean wlqhb = new WatchListQuoteHolderBean();	
		String[] syms = watchListSymbols.split(",");
		
		for(int i=0; i < syms.length; i++){
			syms[i] = syms[i].trim();
		}

		QueryHelper helper = new QueryHelper();
		QueryResult query;
		try{
			query = (QueryResult) helper.getQuote(syms);
			ArrayList<Result> quotes = (ArrayList<Result>) query.results;  
			
			if (quotes != null)
			{
				for (Result r : quotes)
				{
					WatchListQuoteBean wb = new WatchListQuoteBean();
					wb.setSymbol(r.symbol);
					wb.setPrice(r.lastPrice);
					wb.setChange(r.netChange);
					wlqhb.addWatchListQuoteBean(wb);
				}
			}		
			return wlqhb;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}