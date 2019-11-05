package com.san.analytical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TempOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(1); 

		Set<Integer> numbers = new HashSet<>(); 

		numbers.add(4); 

		numbers.add(3); 

		numbers.add(4); 

		numbers.add(5); 

		numbers.add(new Integer(6)); 

		numbers.add(a); 

		List sortedList = new ArrayList(numbers); 

		Collections.sort(sortedList, Collections.reverseOrder()); 

		System.out.println(sortedList); 

	}

}
