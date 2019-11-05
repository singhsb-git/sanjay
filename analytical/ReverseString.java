package com.san.analytical;

public class ReverseString {

	public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        /*
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }
     */   
        for(int j = str.length()-1; j >= 0; j--){
        	strBuilder.append(str.charAt(j));
        }

        return strBuilder.toString();
    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }
    
    
    public static void main(String[] args){
    	
    	System.out.println("Reversing String without using reverse api - "+ReverseString.reverse("Sanjay"));
    	
    	System.out.println("Reversing String recursively, without using reverse api - "+ReverseString.reverseRecursively("Sanjay"));
    	
    }

}
