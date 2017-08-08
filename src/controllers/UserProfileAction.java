package controllers;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.WatchListBean;
import model.WatchListQuoteHolderBean;
import model.WatchListsBean;
import services.SQLHelper;
import services.WatchListParserService;
import services.WatchListSymbolHelper;

public class UserProfileAction extends ActionSupport{
	private static final long serialVersionUID = 2650084195542815421L;
	private String username = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
	private String watchlistName;
	private WatchListBean wlb;
	private String symbols;
	private WatchListQuoteHolderBean wlqhb;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWatchlistName() {
		return watchlistName;
	}
	public void setWatchlistName(String watchlistName) {
		this.watchlistName = watchlistName;
	}
	public WatchListBean getWlb() {
		return wlb;
	}
	public void setWlb(WatchListBean wlb) {
		this.wlb = wlb;
	}
	public String getSymbols() {
		return symbols;
	}
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
	public WatchListQuoteHolderBean getWlqhb() {
		return wlqhb;
	}
	public void setWlqhb(WatchListQuoteHolderBean wlqhb) {
		this.wlqhb = wlqhb;
	}

	public String loadWatchList(){
		WatchListsBean wlsb = new WatchListsBean();
		wlsb.setUsername(getUsername());
 	   	wlsb.setWatchlists(SQLHelper.getUserWatchLists(getUsername())); 
 	   	setWlb(wlsb.getWatchListName(getWatchlistName()));   	
 	   	setSymbols(getWlb().getWatchlist());
 	   	setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));

	   	ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
		ServletActionContext.getRequest().getSession().setAttribute("loadWatchList", wlsb.getWatchListName(getWatchlistName()));
		return "SUCCESS";
	}
	
	
	
	
	
}
