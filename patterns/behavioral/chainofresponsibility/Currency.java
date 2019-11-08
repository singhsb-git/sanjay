/**
 * 
 */
package com.san.patterns.behavioral.chainofresponsibility;

/**
 * @author Huskytwin
 *
 */
public class Currency {

	private int amount;
	
	public Currency(int amt){
		this.amount=amt;
	}
	
	public int getAmount(){
		return this.amount;
	}
}
