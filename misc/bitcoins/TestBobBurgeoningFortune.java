package com.san.misc.bitcoins;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.san.misc.bitcoins.Bitcoins;
import com.san.misc.bitcoins.BobBurgeoningFortune;

public class TestBobBurgeoningFortune {
	
	private String fileName;
	private Bitcoins bitcoins;

	@Before
	public void setUp() throws Exception {
		// Assumption that the file is stored at below location
		fileName = "C:/Data/Input/bobs_crypto.txt";
		BobBurgeoningFortune bobBurgeoningFortune = new BobBurgeoningFortune();
		bitcoins = bobBurgeoningFortune.getBitcoinsReport(fileName);
	}

	@Test
	public void testPresenceOfPrices() throws Exception{
	
		bitcoins.getBitcoinCryptos().forEach(System.out::println);	
	    System.out.println("Total Investment value in EUR = "+ bitcoins.getTotalInvestmentValue());
		
		assertThat(bitcoins.getBitcoinCryptos().size(), is(3));
		assertThat(bitcoins.getTotalInvestmentValue(), notNullValue());
		assertThat(bitcoins.getBitcoinCryptos().get(0).getPricePerCoin(), notNullValue());
		assertThat(bitcoins.getBitcoinCryptos().get(1).getPricePerCoin(), notNullValue());
		assertThat(bitcoins.getBitcoinCryptos().get(2).getPricePerCoin(), notNullValue());	
	}
	
	@Test
	public void testVerifyTotalInvestmentValues() throws Exception{
		assertThat(bitcoins.getTotalInvestmentValue(), is(getTotalInvestmentValue()));			
	}
	
	private Double getTotalInvestmentValue(){
		Double totalInvestValue = 0.0;
		for(int i=0; i < bitcoins.getBitcoinCryptos().size(); i++){
			totalInvestValue += bitcoins.getBitcoinCryptos().get(i).getTotalPrice();
		}
			double scale = Math.pow(10, 3);
		totalInvestValue =  Math.round(totalInvestValue * scale) / scale;
		
		return totalInvestValue;
	}
	

}
