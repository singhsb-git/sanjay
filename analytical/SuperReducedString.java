package com.san.analytical;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReducedString {

    static String super_reduced_string(String s){
        // Complete this function

    	String tmpStr = "";
    
    	while(true){
    		s = getNoAdjacentString(s);
    		
    		if(!tmpStr.equals(s)  )
    			tmpStr = s;
    		else
    			break;
    	}
		
		return tmpStr;
    		
    }
    
    public static String getNoAdjacentString(String s){
    	String tmpStr = "";
    	int i = 0;
    
   // 	System.out.println("tmp initial->"+tmpStr);
    	
    	while(true){
    		int nextIndex = i+1;
			if(nextIndex < s.length()){
				if(s.charAt(i) != s.charAt(nextIndex) ){
					tmpStr += s.charAt(i);
					//System.out.println("+tmpStr ->"+tmpStr+ ", i->"+i);
					s = s.substring(i+1);
				}
				else{
					s = s.substring(i+2);
				}
			}
			else{
				if(s.length() > 0)
					tmpStr += s.charAt(0);
				//System.out.println("-s ->"+s+ ", i->"+i);
				break;
				
			}
			
			
    	}
		
    	if(tmpStr.length() == 0)
    		tmpStr = "Empty String";
		return tmpStr;
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
