package com.san.analytical;

public class FindSecondHighestInOnePassArray {
	
	public static void main(String[] arg){
		
		Integer[] arr = {-1, -5, 7, 6, 8, 9, -3, 10}; 
		
		int firstHi = arr[0];
		int secondHi = arr[1];
		for(int i=0; i < arr.length; i++){
			if(i > 0 ){
				if(arr[i] > firstHi){
					secondHi = firstHi;
					firstHi = arr[i];
					//System.out.println("1-->"+firstHi+" : "+secondHi);
				}else if(arr[i] > secondHi){
					secondHi = arr[i];
					//System.out.println("2-->"+firstHi+" : "+secondHi);
				}
			}
			
		}
		
		System.out.println("SecondHi-->"+ secondHi);
	}

}
