/**
 * 
 */
package com.san.patterns.behavioral.chainofresponsibility;

/**
 * @author Huskytwin
 *
 */
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}
