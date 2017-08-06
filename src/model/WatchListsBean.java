package model;

import java.util.List;

public class WatchListsBean {
	private List<WatchListBean> watchlists;
	private String username;

	public List<WatchListBean> getWatchlists() {
		return watchlists;
	}

	public void setWatchlists(List<WatchListBean> watchlists) {
		this.watchlists = watchlists;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public WatchListBean getWatchListName(String watchListName){
		WatchListBean wb = new WatchListBean();
		for(WatchListBean w : this.watchlists){
			if(w.getWatchListName().equals(watchListName)){
				wb = w;
			}
		}
		return wb;
	}

}
