package com.san.collection;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int age;
	
	public Employee(){
	}
	
	public Employee(int id, String name, int age ){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("equals ----------->"+toString());
		if(this == obj)
			return true;
		if((obj == null) || (getClass() != obj.getClass()))
			return false;
		
		Employee that = (Employee)obj;
		
		return ((id == that.getId()) &&
				(name.equals(that.getName())) &&
					(age == that.getAge()));
	}
	
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("hashCode ----------->"+ toString());
		return Objects.hash(id, name, age);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{id="+id+", name="+name+", age="+age+"}";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return (this.id - o.id);
	}
	
	
	
	

}
