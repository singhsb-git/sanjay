package com.san.misc;

import java.util.Arrays;
import java.util.Comparator;

public class Employee_ComparatorSortByIdAndName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int flag = o1.getId() - o2.getId();
        if(flag==0) flag = o1.getName().compareTo(o2.getName());
        return flag;
    }
    
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	//sorting custom object array
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);
        
        //sort employees array using Comparator by Salary
        Arrays.sort(empArr, new Employee_ComparatorSortByIdAndName());
        System.out.println("Employees list sorted by ID and name:\n"+Arrays.toString(empArr));
        
      //sort employees array using Comparator by Salary
        Arrays.sort(empArr, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary() - e2.getSalary());
            }
        });
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

	}

}
