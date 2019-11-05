package com.san.misc;

public class StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        String s4 = s3;
        
        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        System.out.println("s4 == s3 :"+(s4==s3));
//------------------------------------------------------        
       // String s5 = "Hello".concat("World");
        String s5 = "HelloWorld";
        String s6 = new String("HelloWorld"); 
        //String s7 = s5;
        //String s7 = s5.intern(); // This creates a copy of s5 in String pool hence they will not be equal
        String s7 = s6.intern(); // This creates a copy of s6 in String pool hence they will not be equal
        
        System.out.println("(s5 == s7) :"+(s5 == s7)); 
        System.out.println("(s5 == s6) :"+(s5 == s6)); 
        System.out.println("(s6 == s7) :"+(s6 == s7)); 
    }

}
