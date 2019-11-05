package com.san.misc.bitcoins;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BitcoinCrypto {
	String bitcoinSymbol;
	int count;
	Double pricePerCoin;
	
	public Double getPricePerCoin() {
		return pricePerCoin;
	}
	public void setPricePerCoin(Double pricePerCoin) {
		this.pricePerCoin = pricePerCoin;
	}
	public Double getTotalPrice() {
		if(pricePerCoin != null){
			Double tmpVal = ((Double)(pricePerCoin * count));
			double scale = Math.pow(10, 3);
		    return Math.round(tmpVal * scale) / scale;		
		}
		return (double) 0;
	}
	
	public String getBitcoinSymbol() {
		return bitcoinSymbol;
	}
	public void setBitcoinSymbol(String bitcoinSymbol) {
		this.bitcoinSymbol = bitcoinSymbol;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "[bitcoinSymbol="+bitcoinSymbol+
				", count="+count+
				", pricePerCoin="+pricePerCoin+
				", totalPrice="+getTotalPrice()+"]";
	}
	
	

}
