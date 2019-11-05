package com.san.analytical;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class InsertionSort2 {
	    
	    public static void insertIntoSorted(int[] ar) {
	    	for(int i = 1; i < ar.length; i++)
	        {
	            for(int j = i; j > 0; j--)
	            {
	                if(ar[j-1] <= ar[j])//In the right spot
	                {
	                    printArray(ar);
	                    break;
	                }
	                else//Swap
	                {
	                    int tmp = ar[j];
	                    ar[j] = ar[j-1];
	                    ar[j-1] = tmp;
	                    if(j-1 == 0) printArray(ar);
	                }
	            }
	         }     
	        
	    }
	    
	    
	    
	  private static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	         for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	         }
	         insertIntoSorted(ar);
	}

}
