package com.san.multithreading.threadpool;

import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future; 

/** * Simple Java program to demonstrate how to use Callable and Future class in * Java. 
You can use FutureTask for asynchronous processing. * * @author WINDOWS 8 * */ 

public class CallableDemo{ 

	public static void main(String... args) throws InterruptedException, ExecutionException { 
		// creating thread pool to execute task which implements Callable 
		ExecutorService es = Executors.newSingleThreadExecutor(); 
		System.out.println("submitted callable task to calculate factorial of 10"); 
		Future result10 = es.submit(new FactorialCalculator(10)); 

		System.out.println("submitted callable task to calculate factorial of 15"); 
		Future result15 = es.submit(new FactorialCalculator(15)); 

		System.out.println("submitted callable task to calculate factorial of 20"); 
		Future result20 = es.submit(new FactorialCalculator(20)); 
		
		System.out.println("Calling get method of Future to fetch result of factorial 10"); 
		long factorialof10 = (long)result10.get(); 
		System.out.println("factorial of 10 is : " + factorialof10); 

		System.out.println("Calling get method of Future to get result of factorial 15"); 
		long factorialof15 = (long)result15.get(); 
		System.out.println("factorial of 15 is : " + factorialof15); 

		System.out.println("Calling get method of Future to get result of factorial 20"); 
		long factorialof20 = (long)result20.get(); 
		System.out.println("factorial of 20 is : " + factorialof20); 
		
		es.shutdown();
	} 
} 

class FactorialCalculator implements Callable<Long> { 

	private int number; 

	public FactorialCalculator(int number){ 
	this.number = number; 
	} 

	@Override 
	public Long call() throws Exception { 
		return factorial(number); 
	} 
	
	private long factorial(int n) throws InterruptedException {
		long result = 1; 
		
		while (n != 0) { 
			result = n * result; 
			n = n - 1; 
			Thread.sleep(100); 
		} 
		
		return result; 
	} 
}