package com.san.analytical;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] intArray = new Integer[6];
		intArray[0] = new Integer(1);
		intArray[1] = new Integer(4);
		intArray[2] = new Integer(5);
		intArray[3] = new Integer(12);
		intArray[4] = new Integer(29);
		intArray[5] = new Integer(9);
		
		// Comparator Ascending sorting ---------------------
		Arrays.sort(intArray, new Comparator<Integer>() {
			@Override
            public int compare(Integer e1, Integer e2) {
                return (e1 - e2);
            }
        });
		
		System.out.println("Value of sorted arrays ASC ->");
		for(int i=0;i<intArray.length; i++){
			System.out.println(intArray[i]);
		}
		
		// Lamda Descending sorting ----------------------
		Arrays.sort(intArray,(Integer e1, Integer e2) -> (e2 - e1));
		System.out.println("Value of sorted arrays DESC->");
		for(int i=0;i<intArray.length; i++){
			System.out.println(intArray[i]);
		}
		
		// Array Sorting -----------------
		
		Integer[] intArray1 = {1, 2, 9, 8, 3, 6};
		Arrays.sort(intArray1, (i1, i2)->(i1-i2));
		System.out.println("Value of sorted arrays ASC-1 ->"+Arrays.toString(intArray1));
		// deepToString - This method is designed for converting multidimensional arrays to strings. 
		System.out.println("Value of sorted arrays ASC-1 ->"+Arrays.deepToString(intArray1));
		
		// ArrayList Sorting using Collections.sort --------------
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(9);
		list.add(8);
		list.add(3);
		list.add(6);
		
		Collections.sort(list, (i1, i2)->(i1-i2));
		System.out.println("Value of sorted arrays ASC-2 ->"+list.toString());
		list.forEach(x->System.out.println(x));
		
		// ArrayList Sorting using Collections.sort -------------------
		
		List<Integer> list1 = Arrays.asList(1, 3, 9, 8, 3, 6);
		
		//The above list created using asList becomes almost immutable 
		//	as methods add(), remove() does not work.
		
		/*list1.add(1);
		list1.add(2);
		list1.add(9);
		list1.add(8);
		list1.add(3);
		list1.add(6);*/	
		
		Collections.sort(list1, (i1, i2)->(i1-i2));
		System.out.println("Value of sorted arrays ASC-3 ->"+list1.toString());
		
		// ArrayList Sorting using Collections.sort -------------------
		// one of the ways to make Arrays.asList as muttable.
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 9, 8, 3, 6));
		list2.add(23);
		list2.add(0);
		list2.add(-1);
		 
		Collections.sort(list2, (i1, i2)->(i1-i2));
		System.out.println("Value of sorted arrays ASC-4 ->"+list2.toString());
		
		// ArrayList Sorting using Collections.sort -------------------
		String[] str = {"san", "man", "ran", "an", "nan"};
		
		Arrays.sort(str, (s1, s2)->(s1.compareTo(s2)));
		System.out.println("Value of sorted arrays for string , ASC-4 ->"+Arrays.deepToString(str));
		

	}

}
