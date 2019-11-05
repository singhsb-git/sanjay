package com.san.analytical;

import java.util.ArrayList;
import java.util.List;

import com.san.misc.Employee;

public class FixCode_1 {
	
	public static void main(String[] args){
		
		List<Employee> employees = new ArrayList<>(); 

		employees.add(new Employee("Paul")); 

		employees.add(new Employee("John")); 

		employees.add(new Employee("George")); 

		employees.add(new Employee("Ringo")); 
/* erroneous code
		for (Employee e : employees) { 

			if (e.getName() == "John") { 
	
				employees.remove(e); 
	
			} 

		} 
		*/
		/* Corrected code */
		List<Employee> employees_out = new ArrayList<>();
		for (Employee e : employees) { 

			if (e.getName() != "John") { 
	
				employees_out.add(e); 
	
			} 

		} 

		System.out.println("employees -> "+employees); 
		System.out.println("employees_out -> "+employees_out);
		
	}

}
