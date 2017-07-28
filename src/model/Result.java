package model;

public class Result {
    public String symbol, exchange, name, dayCode, 
    		serverTimestamp, mode, tradeTimestamp, 
    		unitCode, flag, fiftyTwoWkHighDate, fiftyTwoWkLowDate;
    public float lastPrice, netChange, fiftyTwoWkHigh, 
    		fiftyTwoWkLow, percentChange, open, high, low, 
    		close, volume;

    public Result() { } 
    
    public Result(String symbol, String exchange, String name, 
    		String dayCode, String serverTimestamp, String mode, 
    		float lastPrice, String tradeTimestamp, float netChange, 
    		float percentChange, String unitCode, float open, float high, 
    		float low, float close, String flag, float volume, 
    		float fiftyTwoWkHigh, String fiftyTwoWkHighDate, 
    		float fiftyTwoWkLow, String fiftyTwoWkLowDate) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.name = name;
        this.dayCode = dayCode;
        this.serverTimestamp = serverTimestamp;
        this.mode = mode;
        this.lastPrice = lastPrice;
        this.tradeTimestamp = tradeTimestamp;
        this.netChange = netChange;
        this.percentChange = percentChange;
        this.unitCode = unitCode;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.flag = flag;
        this.volume = volume;
        this.fiftyTwoWkHigh = fiftyTwoWkHigh;
        this.fiftyTwoWkHighDate = fiftyTwoWkHighDate;
        this.fiftyTwoWkLow = fiftyTwoWkLow;
        this.fiftyTwoWkLowDate = fiftyTwoWkLowDate;
    }

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayCode() {
		return dayCode;
	}

	public void setDayCode(String dayCode) {
		this.dayCode = dayCode;
	}

	public String getServerTimestamp() {
		return serverTimestamp;
	}

	public void setServerTimestamp(String serverTimestamp) {
		this.serverTimestamp = serverTimestamp;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(String tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFiftyTwoWkHighDate() {
		return fiftyTwoWkHighDate;
	}

	public void setFiftyTwoWkHighDate(String fiftyTwoWkHighDate) {
		this.fiftyTwoWkHighDate = fiftyTwoWkHighDate;
	}

	public String getFiftyTwoWkLowDate() {
		return fiftyTwoWkLowDate;
	}

	public void setFiftyTwoWkLowDate(String fiftyTwoWkLowDate) {
		this.fiftyTwoWkLowDate = fiftyTwoWkLowDate;
	}

	public float getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(float lastPrice) {
		this.lastPrice = lastPrice;
	}

	public float getNetChange() {
		return netChange;
	}

	public void setNetChange(float netChange) {
		this.netChange = netChange;
	}

	public float getFiftyTwoWkHigh() {
		return fiftyTwoWkHigh;
	}

	public void setFiftyTwoWkHigh(float fiftyTwoWkHigh) {
		this.fiftyTwoWkHigh = fiftyTwoWkHigh;
	}

	public float getFiftyTwoWkLow() {
		return fiftyTwoWkLow;
	}

	public void setFiftyTwoWkLow(float fiftyTwoWkLow) {
		this.fiftyTwoWkLow = fiftyTwoWkLow;
	}

	public float getPercentChange() {
		return percentChange;
	}

	public void setPercentChange(float percentChange) {
		this.percentChange = percentChange;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
}