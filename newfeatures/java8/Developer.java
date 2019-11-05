package com.san.newfeatures.java8;

import java.math.BigDecimal;

public class Developer {
	
	private String name;
	private Integer age;
	private BigDecimal salary;
	
	public Developer(String name,
					BigDecimal salary,
					Integer age){
		this.setName(name);
		this.setAge(age);
		this.setSalary(salary);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	
	public String toString(){
		return ("Developer [name="+name+", salary="+salary+", age="+age+"]");
	}
	
	

}
