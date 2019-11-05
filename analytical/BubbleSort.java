/*
 * In Bubble sort every complete inner iteration places(bubbles) next highest toewards the end.
 * This step is repeated for the length time of the array(which is the outer iteration)
 * 
 */

package com.san.analytical;

public class BubbleSort {
	
	private static void BubbleSort(int[] intArr){
		
		int temp = 0;
		
		for(int i=0; i<intArr.length; i++){
			for(int j=1; j < (intArr.length); j++){
				if(intArr[j-1] > intArr[j]){
					temp = intArr[j-1];
					intArr[j-1] = intArr[j];
					intArr[j] = temp;
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intArr[] = {5, 90, 35, 45, 150, 3};
		
		System.out.println("Original values -->");
		for(int i=0; i<intArr.length; i++)
			System.out.print(intArr[i]+" ");
		
		BubbleSort(intArr);
		
		System.out.println("");
		System.out.println("Values after BubbleSprt -->");
		for(int i=0; i<intArr.length; i++)
			System.out.print(intArr[i]+" ");
		
		

	}

}
