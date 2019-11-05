package com.san.analytical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	
	public Fibonacci(){
		
	}
	
	public List<Integer> genFibonacciUpto(Integer upto){
		
		Integer next;
		
		List<Integer> FibSeries = new ArrayList<>(Arrays.asList(0, 1)); 
		
		next = FibSeries.get(FibSeries.size()-1) + FibSeries.get(FibSeries.size()-2);
		while(next <= upto){
			FibSeries.add(next);
			next = FibSeries.get(FibSeries.size()-1) + FibSeries.get(FibSeries.size()-2);
		}
		
		return (FibSeries);
	}
	
	
	public List<Integer> genFibonacciUpto_Recursively(List<Integer> fbList, Integer upto){
		
		Integer next;
		next = fbList.get(fbList.size()-1) + fbList.get(fbList.size()-2);
		
		if(next < upto){
			fbList.add(next);
			genFibonacciUpto_Recursively(fbList, upto);
		}
		
		return fbList;
	}
	
	public List<Integer> genFibonacci_Count_Recursively(List<Integer> fbList, Integer count){
		
		Integer next;
		next = fbList.get(fbList.size()-1) + fbList.get(fbList.size()-2);
		
		if(fbList.size() < count){
			fbList.add(next);
			genFibonacci_Count_Recursively(fbList, count);
		}
		
		return fbList;
	}
	
	
	
	public int genFibonacciRecursively_1(int n){
		if(n <= 1){
			return n;
		}else{
			return genFibonacciRecursively_1(n-1) + genFibonacciRecursively_1(n-2);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibonacci fbs = new Fibonacci();
		
		List<Integer> fibList = fbs.genFibonacciUpto(1000);
		System.out.println("Fibonacci Series - "+fibList.toString()); 
		
		List<Integer> fibListRecurse = fbs.genFibonacciUpto_Recursively(new ArrayList<>(Arrays.asList(0, 1)), 4000);
		System.out.println("Fibonacci Series Recursively - "+fibListRecurse.toString()); 
		
		List<Integer> fibListRecurse_1 = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			fibListRecurse_1.add(fbs.genFibonacciRecursively_1(i));
		}
		
		System.out.println("Fibonacci Series Recursively ... - "+ fibListRecurse_1.toString());
		
		List<Integer> fibListRecurse_2 = fbs.genFibonacci_Count_Recursively(new ArrayList<>(Arrays.asList(0, 1)), 15);
		System.out.println("Fibonacci Series Recursively for fib count  - "+fibListRecurse_2.toString()); 
		
		

	}

}
