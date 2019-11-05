package com.san.analytical;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write java program to create immutable class
 * 
 * @author Huskytwin
 * 
 */

import java.util.HashMap;
import java.util.Iterator;


public final class ImmutableClass {

	private final int id;
	
	private final String name;
	
	private final HashMap<String,String> testMap;
	
	private final Date dob;
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}
	
	public Date getDob() {
		return (Date)dob.clone();
	}

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	
	public ImmutableClass(int i, String n, HashMap<String,String> hm, Date dob){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.name=n;
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}

		this.testMap=tempMap;
		this.dob = dob;
	}
	
	
	
	/**
	 * Constructor performing Shallow Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
/*
	public ImmutableClass(int i, String n, HashMap<String,String> hm, Date dob){
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id=i;
		this.name=n;
		this.testMap=hm;
		this.dob = dob;
	}
*/
	
	
	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int i=10;
		Date dob = new Date();
		
		ImmutableClass ce = new ImmutableClass(i,s,h1, dob);
		
		//Lets see whether its copy by field or reference
		System.out.println(i==ce.getId());
		System.out.println(s==ce.getName());
		System.out.println(h1 == ce.getTestMap());
		System.out.println(dob == ce.getDob());
		
		//print the ce values
		System.out.println("ce id:"+ce.getId());
		System.out.println("ce name:"+ce.getName());
		System.out.println("ce testMap:"+ce.getTestMap());
		System.out.println("ce dob:"+ce.getDob());
		
		//change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		
		// Convert string to date
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "02-04-2013 11:35:42";
        try {
        	dob = dateformat2.parse(strdate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		//print the values again
		System.out.println("ce id after local variable change:"+ce.getId());
		System.out.println("ce name after local variable change:"+ce.getName());
		System.out.println("ce testMap after local variable change:"+ce.getTestMap());
		System.out.println("ce dob after local variable change:"+ce.getDob());
		
		HashMap<String, String> hmTest = ce.getTestMap();
		//hmTest.put("2", "second_change");
		hmTest.put("4", "new");
		
		System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());
		System.out.println("*** local testMap after changing variable from accessor methods:"+hmTest);
		
		Date dob1 = ce.getDob();
	
		// Convert string to date
         dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strdate2 = "02-04-2013 11:35:42";
        try {
        	dob1 = dateformat2.parse(strdate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }	
        long incomingTime = ce.getDob().getTime();
        ce.getDob().setTime(incomingTime+100000);
        System.out.println("ce dob after ce dob variable updatedtime:"+ce.getDob());   

	}


}