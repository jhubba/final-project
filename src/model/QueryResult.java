package model;

import java.util.List;

public class QueryResult {
    public Status status;
    public List<Result> results = null;
    
    public QueryResult() {}
    
    public QueryResult(Status status, List<Result> results) {
        this.status = status;
        this.results = results;
    }
}