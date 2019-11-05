/**
 * 
 * Numeros, the Artist, had two lists A and B , such that B was a permutation of A . 
 * Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another, 
 * some numbers were left out of A. Can you find the missing numbers?

 * Notes:
 * If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both 
 * lists is the same. If that is not the case, then it is also a missing number.
 * You have to print all the missing numbers in ascending order.
 * Print each missing number once, even if it is missing multiple times.
 * The difference between maximum and minimum number in  is less than or equal to .
 * 
 * input:
 * 10
 * 203 204 205 206 207 208 203 204 205 206
 * 13
 * 203 204 204 205 206 207 205 208 203 206 205 206 204
 * 
 * Output:
 * 204 205 206
 */

package com.san.analytical;



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNumbers {

    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function
    	
    	System.out.println("arr ->"+Arrays.toString(arr));
    	System.out.println("brr ->"+Arrays.toString(brr));
    	
    	ArrayList<Integer> tmpbrr = new ArrayList(Arrays.asList(brr));
    
    	for(int i=0; i < arr.length; i++){
    		for(int j=0; j < brr.length; j++){
    			if(arr[i] == brr[j]){
    				brr[j] = -1;
    				break;
    			}
    		}
    		
    	}
    	
  /*  	
    	for(int i=0; i < arr.length; i++){
    		for(int j=0; j < tmpbrr.size(); j++){
    			if((Integer)arr[i] == tmpbrr.get(j)){
    				tmpbrr.set(j, -1);
    				System.out.println("jjjj-->"+tmpbrr.get(j));
    				break;
    			}
    		}
    		
    	}
    	*/
    	
  //  	System.out.println("tmpbrr after traversing ->"+ Arrays.toString( tmpbrr.toArray()));
    	
    //	System.out.println("tmpbrr after traversing ->"+ Arrays.toString( tmpbrr.toArray()));
    	
    	List<Integer> tmp = new ArrayList<Integer>();
    	
    	for(int k=0; k < brr.length; k++){
    		if((brr[k] != -1) && (!tmp.contains(brr[k])))
    			tmp.add(brr[k]);
    	}

/*    	
    	
    	for(int k=0; k < tmpbrr.size(); k++){
    		if((tmpbrr.get(k) != -1 ) &&  (!tmp.contains(tmpbrr.get(k))))
    			tmp.add(tmpbrr.get(k));
    	}
*/    	
    	
    	Collections.sort(tmp, (o1, o2)-> o1-o2);
    	
    	System.out.println("tmp after traversing ->"+tmp.toString());
    	
    	int[] tmp1 = new int[tmp.size()];
    	for(int i=0; i < tmp.size(); i++) {
    		tmp1[i] = tmp.get(i);
    	}
    		
    	System.out.println("tmp1 after traversing ->"+Arrays.toString(tmp1));
    	return tmp1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
       
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
