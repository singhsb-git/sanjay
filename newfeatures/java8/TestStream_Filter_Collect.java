package com.san.newfeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream_Filter_Collect {
	
	public static void main(String[] args) {

		 // Before Java 8  -------------------------------------
		
		 List<String> lines = Arrays.asList("spring", "node", "mkyong");
	        List<String> result = getFilterOutput(lines, "mkyong");
	        System.out.println("Output from Before Java 8 filtering - ");
	        for (String temp : result) {
	            System.out.println(temp);    //output : spring, node
	        }
		
		
		// Java 8 -------------------------------------
		
        List<String> lines_1 = Arrays.asList("spring", "node", "mkyong");
        System.out.println("Output from Java 8 Stream filtering - ");

        List<String> result_1 = lines_1.stream()         // convert list to stream
                .filter(line -> !"mkyong".equals(line))  // we don't like mkyong
                .collect(Collectors.toList());           // collect the output and convert streams to a List

        result_1.forEach(System.out::println);                //output : spring, node

    }
	
	
	 private static List<String> getFilterOutput(List<String> lines, String filter) {
	        List<String> result = new ArrayList<>();
	        for (String line : lines) {
	            if (!"mkyong".equals(line)) { // we dont like mkyong
	                result.add(line);
	            }
	        }
	        return result;
	    }


}
