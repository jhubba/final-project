package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import com.google.gson.Gson;

public class QueryHelper {
	private final String KEY = "&key=bd933c2d2f7d0545e237ce85a570637c"; 
	private final String tail = "&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&mode=R";
		
	public ArrayList<QueryResult> getQuote(String[] symbols) throws Exception {

		String endpoint = "http://marketdata.websol.barchart.com/getQuote.json?";
		StringBuilder sb = new StringBuilder("&symbols=").append(String.join(",", symbols));
		CloseableHttpClient client = HttpClients.createDefault();
		ArrayList<QueryResult> list = new ArrayList<>();
		
		try {
			HttpGet request = new HttpGet(endpoint + KEY + sb.toString() + tail);
			CloseableHttpResponse response = client.execute(request);
			
			try {
				int status = response.getStatusLine().getStatusCode();
				if (status == 200) {
					BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					String output = "";
					Gson gson = new Gson();
					QueryResult qr = null;
					while ((output = br.readLine()) != null) {
						qr = gson.fromJson(output, QueryResult.class);
						list.add(qr);
					}
				}
				return list;
			} finally {
				response.close();
			}
		} finally {
			client.close();
		}
	}	
	
//	public static void main (String[] args) throws Exception {
//		QueryHelper query = new QueryHelper();
//		String stuff = query.getQuote(new String[]{"AAPL", "GOOG", "FB"});
//		
//		System.out.println(stuff);
//	}
}

//URL to get quote by symbols
//http://marketdata.websol.barchart.com/
//getQuote.json
//?key=bd933c2d2f7d0545e237ce85a570637c
//&symbols=AAPL%2CGOOG%2CFB
//&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate
//&mode=I