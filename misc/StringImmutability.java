package com.san.misc;

public class StringImmutability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Sachin";
		String str = s;
		System.out.println("Original String s : " + s +" and assigned str=s: "+ str);
		str=str.concat(" Tendulkar");
		System.out.println("After modifying 'str' using concat, Original String 's' : " + s + " and str : "+str);
		System.out.println("Once the string object is created only new String objects (reference) can be reassigned but the value in the reference object cannot be modified");


	}

}
