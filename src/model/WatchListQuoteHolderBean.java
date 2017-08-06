package model;

import java.util.ArrayList;
import java.util.List;

public class WatchListQuoteHolderBean {
	private List<WatchListQuoteBean> watchListHolder = new ArrayList<>();

	public List<WatchListQuoteBean> getWatchListHolder() {
		return watchListHolder;
	}

	public void setWatchListHolder(List<WatchListQuoteBean> watchListHolder) {
		this.watchListHolder = watchListHolder;
	}
	
	public void addWatchListQuoteBean(WatchListQuoteBean bean){
		this.watchListHolder.add(bean);
	}
}
