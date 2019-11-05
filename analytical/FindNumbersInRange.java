/*
 * 
 * Write a method that takes 3 unsigned integers as input. The first integer represent digit(0-9), 
 * while second and third represent start and end of the range. You need to find each numbers in
 * the range that contains the digit and then return a string with each of those numbers separated by space.
 */
package com.san.analytical;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindNumbersInRange {
	
	static String find_numbers(int digit, int start, int end) {
		
		String tmpOut = "";
		
		for(int i = start; i <= end; i++){
			ArrayList<Integer> array = new ArrayList<Integer>();
			int temp = i;
			
			do{
				array.add(temp % 10);
				temp /= 10;
			} while  (temp > 0);
			
			for(int j = 0; j < array.size(); j++){
				if(array.get(j) == digit){
					if(tmpOut.length() != 0)
						tmpOut += " ";
					tmpOut += i;
					break;
				}
			}
			
		}

		return tmpOut;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        String res;
        
        int _digit;
        _digit = Integer.parseInt(in.nextLine().trim());
        
        int _start;
        _start = Integer.parseInt(in.nextLine().trim());
        
        int _end;
        _end = Integer.parseInt(in.nextLine().trim());
        
        res = find_numbers(_digit, _start, _end);
        
        System.out.println(res);

	}

}
