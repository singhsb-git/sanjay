package com.san.misc.bitcoins;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BobBurgeoningFortune {
	
	public Bitcoins getBitcoinsReport(String fileName) throws Exception{
		Scanner scanner = null;
		CryptoCompareImpl cryptoCompareImpl = new CryptoCompareImpl();
		scanner = new Scanner(new FileReader(fileName));
		List<BitcoinCrypto> bitcoinCryptos = new ArrayList<>();
		BitcoinCrypto bitcoinCrypto;
		Double totalInvestValue = 0.0;
		String line;
		while (scanner.hasNext()) {
	         line = scanner.next();
	         String[] columns = line.split("=");
             bitcoinCrypto = new BitcoinCrypto();
             bitcoinCrypto.setBitcoinSymbol(columns[0]);
             bitcoinCrypto.setCount(Integer.valueOf(columns[1]));
             bitcoinCryptos.add(bitcoinCrypto);
	    }
	  
	    //-----------------  Call to REST API and calculate total price -------------------
		
		// calculate total price of individual bitcoins
	    for(int i=0; i < bitcoinCryptos.size(); i++){
	    	bitcoinCrypto = bitcoinCryptos.get(i);
	    	String out = cryptoCompareImpl.getBitCoinPrice(bitcoinCrypto.getBitcoinSymbol(), "EUR"); 
	    	if(out != null){
	    		String[] outColumns = out.split(":");
	    		Double bitCoinsTotalPrice = Double.valueOf(outColumns[1].trim().substring(0, outColumns[1].length()-1));
	    		bitcoinCrypto.setPricePerCoin(bitCoinsTotalPrice);
	    		totalInvestValue = totalInvestValue + bitcoinCrypto.getTotalPrice();
	    	}
	    }
	    
	    Bitcoins bitcoins = new Bitcoins();
	    bitcoins.setBitcoinCryptos(bitcoinCryptos);
	    double scale = Math.pow(10, 3);
	    totalInvestValue =  Math.round(totalInvestValue * scale) / scale;
	    bitcoins.setTotalInvestmentValue(totalInvestValue);
	    
	    return bitcoins;
	}
	

	public static void main(String[] args) throws Exception{

		// ---------- input ----------------------------
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter file location -->");
		String fileName = reader.readLine();
		
		// --------- processing ------------------------
		BobBurgeoningFortune bobBurgeoningFortune = new BobBurgeoningFortune();
		Bitcoins bitcoins = bobBurgeoningFortune.getBitcoinsReport(fileName);
	    
		// --------- output ---------------------------
		bitcoins.getBitcoinCryptos().forEach(System.out::println);	
	    System.out.println("Total Investment value in EUR = "+ bitcoins.getTotalInvestmentValue());
	}
}
