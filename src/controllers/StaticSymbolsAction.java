package controllers;

import model.*;

import java.io.Serializable;
import java.util.ArrayList;

public class StaticSymbolsAction implements Serializable {

	private static final long serialVersionUID = -4949806602233372536L;
	private String sym = "";
	public StaticSymbolsAction() {}
			
	public String getSym() {
		String[] symbols = new String[3];
		float[] prices = new float[3];
		float[] changes = new float[3];
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
					.append(symbols[i].toUpperCase() + ": ");
				if(changes[i] < 0 ) {
				sb.append("<span class='changenegative'>")
				.append(prices[i] + " ")
				.append("</span><span class='changenegative'>" + changes[i]).append("</span></span></div>");
				}
				else {
				sb.append("<span class='changepositive'>")
				.append(prices[i] + " ")
				.append("</span><span class='changepositive'>" + changes[i]).append("</span></span></div>");
				}
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
