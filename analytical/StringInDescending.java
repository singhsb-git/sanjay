package com.san.analytical;

import java.util.Arrays;
import java.util.Collections;

public class StringInDescending {
	
	public static String stringInDescendingOrder(String string){
		char tmpArray[] = string.toCharArray();
		String tmpStr = "";
		
		Arrays.sort(tmpArray);
		
		for(int i=tmpArray.length-1; i >=0; i--){
			tmpStr += tmpArray[i];
		}
		
		return tmpStr;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("original String = 132073091790 and sorted String = "+
		StringInDescending.stringInDescendingOrder("132073091790"));
	
	}

}
