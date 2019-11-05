package com.san.misc;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orString = "Test";
		String reversed = reverse(orString);
		
		System.out.print("Original String: " + orString + " and reversed string is : " + reversed);

	}
	
	
	ReverseString(){
		
	}
	
	
	public static String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }       
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }
      
        return reverse;
    }
	
	

}
