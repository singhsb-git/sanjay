package com.san.misc;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Employee_ComparableSort implements Comparable<Employee_ComparableSort> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee_ComparableSort(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee_ComparableSort emp) {
        //let's sort the employee based on id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }

    @Override
    //this is required to print the user friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
    
    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee_ComparableSort> SalaryComparator = new Comparator<Employee_ComparableSort>() {

        @Override
        public int compare(Employee_ComparableSort e1, Employee_ComparableSort e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };
    
    
    public static void main(String[] args) {
    	//sorting object array
    	Employee_ComparableSort[] empArr = new Employee_ComparableSort[4];
    	empArr[0] = new Employee_ComparableSort(10, "Mikey", 25, 10000);
    	empArr[1] = new Employee_ComparableSort(20, "Arun", 29, 20000);
    	empArr[2] = new Employee_ComparableSort(5, "Lisa", 35, 5000);
    	empArr[3] = new Employee_ComparableSort(1, "Pankaj", 32, 50000);

    	//sorting employees array using Comparable interface implementation
    	Arrays.sort(empArr);
    	System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));
    	
    	//sorting employees array using Comparable interface implementation
    	Arrays.sort(empArr, Employee_ComparableSort.SalaryComparator);
    	System.out.println("Salary Sorting of Employees list:\n"+Arrays.toString(empArr));
    }

}