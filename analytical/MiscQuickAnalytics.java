package com.san.analytical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MiscQuickAnalytics {

	public static String findFirstNonRepeatingChar(String str){
		
		String chOut = null;
		
		for(int i = 0; i < str.length(); i++){
			String ch = null;
			
			for(int j = 0; j < str.length(); j++){
				if((i!=j)&&(str.charAt(i) == str.charAt(j))){
					ch = String.valueOf(str.charAt(i));
					break;
				}
			}
			
			if(ch == null){
				chOut = String.valueOf(str.charAt(i)); 
				break;
			}
		}
		
		return chOut;
	}
	
	
	public static List<Integer> FindSummationPairs(Integer[] intArray, Integer target){
		
		List<Integer> lst = new ArrayList<>();
		
		for(int i = 0; i < intArray.length; i++){
			for(int j = i+1; j < intArray.length; j++){
				if(i != j){
					if(intArray[i]+intArray[j] == target){
						lst.add(intArray[i]);
						lst.add(intArray[j]);	
					}
				}
				
			}
			
		}
		
		return lst;
	}


	public static String StringEncode_1(String str){
		
		String strEncoded = "";
		int cnt;
		
		// traverse list char by char
		for(int i = 0; i < str.length(); i=i+cnt){
			cnt = 1;
			for(int j = i+1; j < str.length(); j++){
				if(str.charAt(i) == str.charAt(j)){
					cnt++;
				}
				else 
					break;
			}
			
			strEncoded = strEncoded + str.charAt(i);
			strEncoded = strEncoded + cnt;
		}
		
		return strEncoded;
	}
	
	
	public static int FindSecondHighestInOnePassArray(Integer[] arr){
		
		int firstHi = arr[0];
		int secondHi = arr[0];
		for(int i=0; i < arr.length; i++){
			if(arr[i] > firstHi){
				secondHi = firstHi;
				firstHi = arr[i];
			}else if(arr[i] > secondHi){
				secondHi = arr[i];
			}
		}
		
		return secondHi;
	}
	
	 public static String stringInDescendingOrder(String string){
	      
	      char tmpArr[] = string.toCharArray();
	      String tmpStr = "";
	      
	      Arrays.sort(tmpArr); // try using comparator.. it might not work as char is not a wrapper class
	      for(int i=tmpArr.length-1; i >=0; i--){
	    	  tmpStr += tmpArr[i];
	      }
	   
	      return tmpStr;
	    }
	 
	 
	 public static List<Integer> getNumberPatternInDecscending(Integer[] intArr, String numPattern){
		 
		 char ch[] = numPattern.toCharArray();
		 List<Integer> outInt =  new ArrayList<>();
		 
		 for(int i = 0; i < intArr.length; i++){
			 boolean found = true;
			 for(int j = 0; j < ch.length; j++){
				 if(!String.valueOf(intArr[i]).contains(String.valueOf(ch[j]))){
					 found = false;
				 }
			 }
			 if(found == true){
				 outInt.add(intArr[i]);
			 }
		 }
		 
		 // sort in descending order
		 
		 Collections.sort(outInt, (o1,o2)-> (o2-o1));
		 
		 return outInt;
	 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1.Find Fist non-repeating char in a string
		
		System.out.println("***** Find Fist non-repeating char in a string");
		String str = "Sanjay";
		String chOut = findFirstNonRepeatingChar(str);
		System.out.println("The first non-repeating char in "+str+" is -> "+chOut);
		
		str = "ajjayynS";
		chOut = findFirstNonRepeatingChar(str);
		System.out.println("The first non-repeating char in "+str+" is -> "+chOut);
		
		str = "ajjayy";
		chOut = findFirstNonRepeatingChar(str);
		System.out.println("The first non-repeating char in "+str+" is -> "+chOut);
		
		// 2. get the string encoded like aabbbccdeee = a2b3c2d1e3
		
		System.out.println("***** Get the string encoded like aabbbccdeee = a2b3c2d1e3");
		str = "aabbbcddddd";
		chOut = StringEncode_1(str);
		System.out.println("The encoded string for "+ str +" is -> "+chOut);
		
		// 3. get an array of summation pairs of integers for given array of integers and summation target
		
		System.out.println("***** Array of summation pairs of integers for given array of integers and summation target");
		Integer[] intArray = {0, 5, 10, 5, 15, 3, 1, 4, -5, 20, -10, 11, -1}; 
		Integer target = 10;
		
		List<Integer> lst =  FindSummationPairs(intArray, target);
		System.out.println("The summation pairs are -> "+lst);
		
		// 4.Find the second highest in the integer array
		
		System.out.println("***** Find the second highest in the integer array");
		Integer[] arr = {1, -1, -5, 7, 6, 8, 9, -3, 10, 12}; 
		
		int secHighest = FindSecondHighestInOnePassArray(arr);
		System.out.println("The original list -> "+Arrays.toString(arr));
		System.out.println("The second highest ->"+secHighest);
		
		// 5. Order String in Descending order
		System.out.println("***** Order String in Descending order");
		str = "afghbcikde";
		System.out.println("Original String -> "+str);
		str = stringInDescendingOrder(str);
		System.out.println("Descending String -> "+str);
		
		// 6. Print number in descending order which contains 1, 2 and 3 in their digits or any pattern.
		System.out.println("***** Print number in descending order which contains 1, 2 and 3 in their digits or any pattern.");
		Integer[] arr1 = {123, 1232, 456, 234, 32145};
		System.out.println("Original Array -> "+Arrays.toString(arr1));
		List<Integer> intArr = getNumberPatternInDecscending(arr1, "123");
		System.out.println("Output Array -> "+intArr.toString());
		

	}

}
