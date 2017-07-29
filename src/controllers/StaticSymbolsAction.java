package controllers;

import com.opensymphony.xwork2.ActionSupport;
import model.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class StaticSymbolsAction extends ActionSupport {
	
	private static final long serialVersionUID = 2398066631321170705L;
	private String[] symbols;
	private float[] prices;
	private float[] changes;
	
	@Override
	public String execute() throws Exception {
		
		QueryHelper helper = new QueryHelper();
		QueryResult query = (QueryResult) helper.getQuote(new String[] {"voo","iyy","vti"});
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
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getRequestDispatcher("index.jsp").forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		}
		return SUCCESS;
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
