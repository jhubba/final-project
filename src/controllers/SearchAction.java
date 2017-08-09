package controllers;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.QueryHelper;
import model.Result;

public class SearchAction extends ActionSupport {
	private static final long serialVersionUID = -4703251445471173407L;
	private Result query;
	private String symbol;

	public String execute() {		
		QueryHelper helper = new QueryHelper();
		try {
			query = (Result) helper.getSingleQuote(getSymbol());
			ServletActionContext.getRequest().getSession().setAttribute("query", query);
			return "found";
		} catch (Exception e) {
			e.printStackTrace();
			return "null";
		}
	}
	
	public Result getQuery() {
		return query;
	}

	public void setQuery(Result query) {
		this.query = query;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
