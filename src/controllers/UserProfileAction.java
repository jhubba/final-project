package controllers;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.QueryHelper;
import model.Result;
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
	private String removeSymbol;
	private boolean refreshList = false;
	private Result query;
	private String symbol;
	private String addSymbol;
	
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
	public void setWlqhbStatic(WatchListQuoteHolderBean wlqhb) {
		this.wlqhb = wlqhb;
	}
	public String getRemoveSymbol() {
		return removeSymbol;
	}
	public void setRemoveSymbol(String removeSymbol) {
		this.removeSymbol = removeSymbol;
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

	public boolean isRefreshList() {
		return refreshList;
	}

	public void setRefreshList(boolean refreshList) {
		this.refreshList = refreshList;
	}
	public String getAddSymbol() {
		return addSymbol;
	}
	public void setAddSymbol(String addSymbol) {
		this.addSymbol = addSymbol;
	}
	public String loadWatchList(){		
		WatchListsBean wlsb = new WatchListsBean();
		wlsb.setUsername(getUsername());
 	   	wlsb.setWatchlists(SQLHelper.getUserWatchLists(getUsername())); 
 	   	setWlb(wlsb.getWatchListName(getWatchlistName()));   	
 	   	setSymbols(getWlb().getWatchlist());
 	   	
 	   	if(!getSymbols().equals(null) && getSymbols().length() > 0){
 	   		setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
 	   	}
 	   	
	   	if( getWlqhb() != null){
	   		ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
	   		ServletActionContext.getRequest().getSession().setAttribute("loadWatchList", wlsb.getWatchListName(getWatchlistName()));
	   		ServletActionContext.getRequest().getSession().setAttribute("watchlistName", getWatchlistName());
	   		ServletActionContext.getRequest().getSession().setAttribute("symbols", getSymbols());
	   	}
 	   	
		return "SUCCESS";
	}
	
	public String removeQuoteFromWatchList(){
		String user = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
		setWatchlistName(ServletActionContext.getRequest().getSession().getAttribute("watchlistName").toString());
		String rsymbol = getRemoveSymbol();		
		String updateSymbols = ServletActionContext.getRequest().getSession().getAttribute("symbols").toString();	
		setSymbols(WatchListParserService.removeSymbol(rsymbol, updateSymbols));
		SQLHelper.editwatchlist(getSymbols(), getWatchlistName(), user);
		
		if(!getSymbols().equals(null) &&  getSymbols().length() > 0){
			ServletActionContext.getRequest().getSession().setAttribute("symbols", getSymbols());							
			setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
			setRefreshList(true);
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("symbols", "");
		}
			
		if(getWlqhb() != null){
			ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "true");
		}
			
		return "REMOVED";
	}

	public String executeUserProfilePage() {
		setWatchlistName(ServletActionContext.getRequest().getSession().getAttribute("watchlistName").toString());	
		setSymbols(ServletActionContext.getRequest().getSession().getAttribute("symbols").toString());

		if(!getSymbols().equals(null) && getSymbols().length() > 0){
			ServletActionContext.getRequest().getSession().setAttribute("symbols", getSymbols());		
			setRefreshList(true);		
			setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
		}
			
		if(getWlqhb() != null){
			ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "true");
		}
		
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
	
	public String addSymbolToWatchList() {
		String user = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
		setWatchlistName(ServletActionContext.getRequest().getSession().getAttribute("watchlistName").toString());
		String asymbol = getAddSymbol();		
		String updateSymbols = ServletActionContext.getRequest().getSession().getAttribute("symbols").toString();	
		setSymbols(WatchListParserService.addSymbol(asymbol, updateSymbols));
		
//		/**/
//		System.out.println("" + asymbol);
//		System.out.println("New Symbols: " + getSymbols());
//		/**/
		SQLHelper.editwatchlist(getSymbols(), getWatchlistName(), user);
		
		if(!getSymbols().equals(null) &&  getSymbols().length() > 0){
			ServletActionContext.getRequest().getSession().setAttribute("symbols", getSymbols());							
			setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
			setRefreshList(true);
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("symbols", "");
		}
			
		if(getWlqhb() != null){
			ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "true");
		}
		
		return "ADDED";
	}
	
}
