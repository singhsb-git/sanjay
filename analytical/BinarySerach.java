package com.san.analytical;

import java.util.List;

public class BinarySerach {
	
	public int binarySearch(Integer[] lst, int needle)
	{
		
		int min = 0;
		int max = lst.length;
		
		int index = -1;
		int value = 0;
		
		while(min < max){
			index = (min + max)/2;
			value = lst[index];
			
			//System.out.println("index : value -> "+index+" : "+value);
			
			if(value < needle){				
				min = index+1;
				//System.out.println("Greater: min"+min);
			}
			else if(value > needle){
				max = index;
				//System.out.println("Smaller: max"+max);
			}
			else
			{
				return index;
			}
		}
		
		index = -1;
		
		return index;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = {1, 6, 7, 8, 9, 15, 27, 99, 105, 120, 125};
		
		BinarySerach bs = new BinarySerach();
		int index = bs.binarySearch(arr, 99);
		
		System.out.println("*** Value found at index position -> "+index);

	}

}
