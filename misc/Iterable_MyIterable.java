package com.san.misc;


import java.util.Iterator;

public class Iterable_MyIterable<T> implements Iterable<T> {
 
    public T[] a= null;
 
    public Iterable_MyIterable(T[] array){
        this.a = array;
    }
 
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {// Anonymous class Iterator
            private int count=0;
 
            public boolean hasNext(){
                return count < a.length;
            }
            
            public T next(){
                System.out.println("Invoking next()");
                return a[count++];
            }
 
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    
    
    	 
    public static void main(String[] args) {
    	String[] technologies = {"Java", "JEE", "XML"};
    	Iterable_MyIterable<String> entries = new Iterable_MyIterable<String>(technologies);
    	System.out.println("Iterating using normal for loop using implemented Iterable interface");
        for (String tech : entries) {
        	System.out.println(tech);
        }
        
        System.out.println("Iterating using normal while loop using implemented Iterable interface");
        Iterator<String> tech_1 = entries.iterator();
        while (tech_1.hasNext()) {
        	System.out.println(tech_1.next());
        }
    }
  
}