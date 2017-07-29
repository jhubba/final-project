package controllers;

import model.*;
import java.util.ArrayList;

public class StaticSymbolsAction  {
	
	private String[] symbols;
	private float[] prices;
	private float[] changes;
	private String sym = "";
			
	public String getSym() {
		QueryHelper helper = new QueryHelper();
		QueryResult query;
		try {
			query = (QueryResult) helper.getQuote(new String[] {"voo","iyy","vti"});
			ArrayList<Result> quotes = (ArrayList<Result>) query.results;  
			
			if (quotes != null)
			{
				int i = 0;
				for (Result r : quotes)
				{
					symbols[i] = r.symbol;
					prices[i] = r.lastPrice;
					changes[i] = r.netChange;
					i++;
				}
			}
		
			StringBuilder sb = new StringBuilder();		
			for (int i = 0; i < symbols.length; i++) {
				sb.append("<div class='col-sm-4'> <span class='label label-default'>")
					.append(symbols[i].toUpperCase()).append("</span><span name='' class=''>")
					.append(prices[i] + " " + changes[i]).append("</span></div>");
			}
			sym = sb.toString();
			return sym;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setSym(String s) {
		this.sym = s;
	}
}
