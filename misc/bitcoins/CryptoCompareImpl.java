package com.san.misc.bitcoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CryptoCompareImpl implements CryptoCompare {
	
	private final String cryptoServiceBaseURL = "https://min-api.cryptocompare.com/data/price";

	@Override
	public String getBitCoinPrice(String symbol, String currency) {
		// TODO Auto-generated method stub
		String output = null;
		try {
			URL url = new URL(cryptoServiceBaseURL+ "?fsym="+symbol+"&tsyms="+currency);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			output = br.readLine();
			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		return output;
	}

}
