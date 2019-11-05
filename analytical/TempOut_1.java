package com.san.analytical;

import java.util.Arrays;
import java.util.List;

public class TempOut_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder(); 

		List<String> letters = Arrays.asList("A","B","C"); 

		for (String letter : letters) { 

		for (int i = 0; i <= letters.indexOf(letter); i++) { 

		sb.append(letter); 

		} 

		sb.append(System.lineSeparator()); 

		} 

		System.out.println(sb.toString()); 

	}

}
