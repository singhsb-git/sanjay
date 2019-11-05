package com.san.analytical;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinAbsDifference {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
    	
    	int tmpVal = 0;
    	
    	for(int i=0; i < arr.length; i++){
    		int a = arr[i];
    		for(int j=i+1; j < arr.length; j++ ){
    			int b = arr[j];
    			
    			if((i==0) && (j == 1))
    				tmpVal = Math.abs(a-b);
    			
				int diff = Math.abs(a-b); 
				if(diff < tmpVal)
					tmpVal = diff;
    		}
    	}
    	
    	return tmpVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}
