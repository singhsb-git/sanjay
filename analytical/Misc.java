package com.san.analytical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Misc {
	
	public static void main(String[] arg){
		
		//--- Sort ArrayList
		sortList();
	}
	
	
	// Sort ArrayList ------------------
	
	public static void sortList(){
		
		List<Integer> intArr = Arrays.asList(1,0,0,1,1,0);
		System.out.println("Original List: "+intArr);
		
		//--- Comparator logic 
		intArr.sort(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return a-b;
			}	
		});
		
		//--- lambda logic 
		// intArr.sort((a, b)->(a-b));
		
		System.out.println("Sorted String: "+intArr);
	}
	

}
