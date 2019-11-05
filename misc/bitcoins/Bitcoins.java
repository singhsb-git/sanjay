package com.san.misc.bitcoins;

import java.util.List;

public class Bitcoins {
	private List<BitcoinCrypto> bitcoinCryptos;
	private Double totalInvestmentValue;
	
	public List<BitcoinCrypto> getBitcoinCryptos() {
		return bitcoinCryptos;
	}
	public void setBitcoinCryptos(List<BitcoinCrypto> bitcoinCryptos) {
		this.bitcoinCryptos = bitcoinCryptos;
	}
	public Double getTotalInvestmentValue() {
		
		return totalInvestmentValue;
	}
	public void setTotalInvestmentValue(Double totalInvestmentValue) {
		this.totalInvestmentValue = totalInvestmentValue;
	}

}
