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
   		ServletActionContext.getRequest().getSession().setAttribute("watchlistName", getWatchlistName());
   		
 	   	if(!getSymbols().equals(null) && getSymbols().length() > 0){
 	   		setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
 	   	}
 	   	
	   	if( getWlqhb() != null){
	   		ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
	   		ServletActionContext.getRequest().getSession().setAttribute("loadWatchList", wlsb.getWatchListName(getWatchlistName()));
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
		if(ServletActionContext.getRequest().getSession().getAttribute("watchlistName") != null){
			setWatchlistName(ServletActionContext.getRequest().getSession().getAttribute("watchlistName").toString());
		}
		if(ServletActionContext.getRequest().getSession().getAttribute("symbols") != null){
			setSymbols(ServletActionContext.getRequest().getSession().getAttribute("symbols").toString());
			
			if(!getSymbols().equals(null) && getSymbols().length() > 0){
				ServletActionContext.getRequest().getSession().setAttribute("symbols", getSymbols());		
				setRefreshList(true);		
				setWlqhb(WatchListSymbolHelper.getSym(getSymbols()));
			}
		}
			
		if(getWlqhb() != null){
			ServletActionContext.getRequest().getSession().setAttribute("getTheQuotes", getWlqhb().getWatchListHolder());
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "true");
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "false");
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
		if(ServletActionContext.getRequest().getSession().getAttribute("watchlistName") != null){
			setWatchlistName(ServletActionContext.getRequest().getSession().getAttribute("watchlistName").toString());
			WatchListsBean wlsb = new WatchListsBean();
			wlsb.setUsername(getUsername());
	 	   	wlsb.setWatchlists(SQLHelper.getUserWatchLists(getUsername())); 
	 	   	
	 	   	for(WatchListBean wb : wlsb.getWatchlists()){
	 	   		if(wb.getWatchListName().equals(getWatchlistName())){
	 	   			setSymbols(wb.getWatchlist());
	 	   		}
	 	   	}
	 	   	
	 	   	setWlb(wlsb.getWatchListName(getWatchlistName()));
	 	   	boolean proceedWithAdd = true;
	 	   	String[] checkSymbols = getSymbols().split(",");
	 	   	if(checkSymbols.length < 20){
	 	   		for(String s: checkSymbols){
		 	   		if(s.equals(getAddSymbol())){
		 	   			proceedWithAdd = false;
		 	   		}
	 	   		}
		 	   	if(proceedWithAdd){
		 	   		setSymbols(WatchListParserService.addSymbol(getAddSymbol(), getSymbols()));
		 	   		SQLHelper.editwatchlist(getSymbols(), getWatchlistName(), getUsername());
		 	   	}
	 	   	}
			
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
		}
		return "ADDED";
	}
	
	public String removeWatchList() {
		String user = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
		SQLHelper.removeWatchlist(user, getWatchlistName());
		
		setWatchlistName(null);
		ServletActionContext.getRequest().getSession().setAttribute("watchlistName", null);
		ServletActionContext.getRequest().getSession().setAttribute("refreshList", "false");		
		
		return "REMOVEDWATCHLIST";
	}
	
	public String addWatchList() {
		String user = ServletActionContext.getRequest().getSession().getAttribute("user").toString();
		setWatchlistName(getWatchlistName().trim());
		
		if(!(getWatchlistName().isEmpty()) && SQLHelper.addWatchlist("", user, getWatchlistName())){
	    	   WatchListsBean wb = new WatchListsBean();
	    	   wb.setUsername(getUsername());
	    	   wb.setWatchlists(SQLHelper.getUserWatchLists(getUsername()));
	    	   ServletActionContext.getRequest().getSession().setAttribute("watchLists", wb);
	    	   ServletActionContext.getRequest().getSession().setAttribute("watchlistName", getWatchlistName());
	    	   
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("refreshList", "false");
			String message= getText("WatchList may already exist or name not entered");    
	        addActionError(message); 
	        
	        if(!getWatchlistName().isEmpty()){
	        	ServletActionContext.getRequest().getSession().setAttribute("refreshList", "true");
	        	loadWatchList();
	        }
	        
	        return "ERRORADDWATCHLIST";
		}
			
		return "ADDEDWATCHLIST";
	}

	
	
}