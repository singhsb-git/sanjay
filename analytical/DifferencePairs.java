/**
 * Given N integers, count the number of pairs of integers whose difference is K.

 * Input Format
 * The first line contains N  and K. 
 * The second line contains  numbers of the set. All the  numbers are unique
 * 
 * Input:
 * 5 2  
 * 1 5 3 4 2 
 * 
 * Output:
 * 3
 * 
 */

package com.san.analytical;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DifferencePairs {

    static int pairs(int k, int[] arr) {
        // Complete this function
    	
    	int tmp = 0;
    	
    	for(int i = 0; i < arr.length; i++){
    		for(int j = i+1; j < arr.length; j++){
    			if(Math.abs(arr[i] - arr[j]) == k)
    				tmp += 1;
    		}	
    	}
    	
    	return tmp;
    }

    public static void main(String[] args) {
        int kDiff = 3;
        int[] arr = {7, 4, 8, 5};
        int result = pairs(kDiff, arr);
        System.out.println("Found parDiff Count="+result+" for pairDiff value="+kDiff+ " for array="+ Arrays.toString(arr));
    }
}
