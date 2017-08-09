package controllers;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.QueryHelper;
import model.Result;

public class SearchAction extends ActionSupport {
	private static final long serialVersionUID = -4703251445471173407L;
	private String symbol;

	public String execute() {
		ServletActionContext.getRequest().getSession().getAttribute(getSymbol());
		QueryHelper helper = new QueryHelper();
		Result query;
		try {
			query = (Result) helper.getSingleQuote("fb");
			ServletActionContext.getRequest().getSession().setAttribute("query", query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "found";
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
