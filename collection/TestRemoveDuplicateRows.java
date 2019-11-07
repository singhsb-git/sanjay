package com.san.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestRemoveDuplicateRows {
	
	public static void main(String[] args){
		Set<Employee> employees = new HashSet<Employee>();
		
		employees.add(new Employee(1, "Sanjay", 25));
		employees.add(new Employee(2, "Neetu", 24));
		employees.add(new Employee(2, "Neetu", 24));
		employees.add(new Employee(3, "Prishu", 10));
		
		System.out.println("Output for HashSet with no duplicates --------->");
		employees.forEach(System.out::println);
		
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()){
		  System.out.println("Iterator:: "+it.next());	
		}
		
		//--------------------------------------------------
		
Set<Employee> employees1 = new TreeSet<Employee>();
		
		employees1.add(new Employee(1, "Sanjay", 25));
		employees1.add(new Employee(2, "Neetu", 24));
		employees1.add(new Employee(2, "Neetu", 24));
		employees1.add(new Employee(3, "Prishu", 10));
		
		System.out.println("Output for TreeSet with no duplicates and sorted --------->");
		employees1.forEach(System.out::println);
		
		it = employees1.iterator();
		while(it.hasNext()){
		  System.out.println("Iterator:: "+it.next());	
		}
		
		
		
		
			
	}

}
