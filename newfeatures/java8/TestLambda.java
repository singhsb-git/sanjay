/**
 * 
java.util.stream.Collectors


Implementations of Collector that implement various useful reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc. 

The following are examples of using the predefined collectors to perform common mutable reduction tasks: 
// Accumulate names into a List
     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

     // Accumulate names into a TreeSet
     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
     Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

     // Compute sum of salaries by department
     Map<Department, Integer> totalByDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                                                   Collectors.summingInt(Employee::getSalary)));

     // Partition students into passing and failing
     Map<Boolean, List<Student>> passingFailing =
         students.stream()
                 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
 */

package com.san.newfeatures.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort - ");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		System.out.println("After Sort by age - ");
		
		//sort by age ------------------------
		
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});

		//lambda here!
		listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());

		//java 8 only, lambda also, to print the List
		listDevs.forEach((developer)->System.out.println(developer));
		
		//sort by name ------------------------

		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		//lambda
		listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));

		//lambda, valid, parameter type is optional
		listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
		
		System.out.println("After Sort by name - ");
		
		listDevs.forEach((developer)->System.out.println(developer));
		
		//sort by salary ------------------------
		
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		//lambda
		listDevs.sort((Developer o1, Developer o2)->o1.getSalary().compareTo(o2.getSalary()));

		//lambda
		listDevs.sort((o1, o2)->o1.getSalary().compareTo(o2.getSalary()));
		
		System.out.println("After Sort by salary - ");
		
		listDevs.forEach((developer)->System.out.println(developer));
		
		// Sort by reversed salary ----------------------
		
		Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		
		listDevs.sort(salaryComparator.reversed());
		
		System.out.println("After Reverse Sort by salary - ");
		
		listDevs.forEach(System.out::println);
		
	}
	

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;

	}

}