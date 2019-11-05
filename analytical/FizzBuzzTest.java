package com.san.analytical;

/**
 * Write a Java program that prints the numbers from 1 to 50. 
 * But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz"
 * 
 * @author Huskytwin
 *
 */

public class FizzBuzzTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 50; i++) { 
			//Multiples of both 3 and 5
			if((i % 3 == 0) && (i % 5 == 0)) System.out.println("FizzBuzz");
			//Multiples of 5 only
			else if(i % 5 == 0) System.out.println("Buzz"); 
			//Multiple of 3 only
			else if(i % 3 == 0) System.out.println("Fizz"); 
			else System.out.println(i); 
		}

	}

}
