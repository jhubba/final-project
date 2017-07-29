package controllers;

import model.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticSymbolsAction extends HttpServlet {
	private static final long serialVersionUID = 2398066631321170705L;
	
	private String[] symbols;
	private float[] prices;
	private float[] changes;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
				String quotesHtml = footerQuotes();
				request.setAttribute("quotes", quotesHtml);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String footerQuotes() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < symbols.length; i++) {
			sb.append("<div class='col-sm-4'> <span class='label label-default'>")
				.append(symbols[i].toUpperCase()).append("</span><span name='' class=''>")
				.append(prices[i] + " " + changes[i]).append("</span></div>");
		}
		return sb.toString();
	}
}
