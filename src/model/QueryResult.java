package model;

import java.util.List;

public class QueryResult {
    public Status status;
    public List<Result> results = null;
    public QueryResult() { }
    public QueryResult(Status status, List<Result> results) {
        this.status = status;
        this.results = results;
    }
    
    public class Status {
        public int code;
        public String message;
        public Status() { }
        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
    
    public class Result {
        public String symbol, exchange, name, dayCode, 
        		serverTimestamp, mode, tradeTimestamp, 
        		unitCode, flag, fiftyTwoWkHighDate, fiftyTwoWkLowDate;
        
        public int percentChange, open, high, low, close, volume;
        public float lastPrice, netChange, fiftyTwoWkHigh, fiftyTwoWkLow;

        public Result() { }
        
        public Result(String symbol, String exchange, String name, 
        		String dayCode, String serverTimestamp, String mode, 
        		float lastPrice, String tradeTimestamp, float netChange, 
        		int percentChange, String unitCode, int open, int high, 
        		int low, int close, String flag, int volume, 
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
    }
}