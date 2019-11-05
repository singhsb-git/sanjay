package com.san.analytical;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "edcba";
		
		String sorted =
		        Stream.of(str.split(""))
		        .sorted()
		        .collect(Collectors.joining());
		
		System.out.println("Sorted String -->"+ sorted);
		
		// other way of sorting... this is easier... ;-)
		String al = "san moon moon and";
		String[] strArr = al.split(" ");
		
		Arrays.sort(strArr);
		System.out.println("---->"+Arrays.toString(strArr));
		
		// other Stream way to get array of String and print
		String[] stringArray =  Stream.of(al.split(" "))
									.toArray(size -> new String[size]);
		Arrays.sort(stringArray);
		Arrays.stream(stringArray).forEach(System.out::println);
		

	}

}
