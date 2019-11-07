package com.san.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
  * Java Program to demonstrate How to use LinkedHashMap, TreeMap and HashMap.
  * It shows that HashMap doesn't guarantee any order, TreeMap keeps them in 
  * sorted order determined by default using Comparable or explicit Comparator
  * provided by client, and LinkedHashMap also keep mapping in order they
  * are added or accessed., 
  *
  * @author Javin Paul
  */
public class MapTest {    
   
    public static void main(String args[]){
     
        //Using HashMap as general purpose single threaded cache
        Map<Integer, String> cache = new HashMap<>();
        cache.put(1, "Stuart");
        cache.put(2, "Steven");
        cache.put(3, "James");
        cache.put(4, "Ian");
        System.out.printf("Name of Employee with id %d is %s %n", 1, cache.get(1));
        System.out.println("Order of Entries in HashMap - Not guaranteed");
        System.out.println(cache);
       
        //Using TreeMap to create a sorted cache, sorting keys on reverse order
        SortedMap<Integer, String> sortedCache = new TreeMap<>(Collections.reverseOrder());
        sortedCache.putAll(cache);
        System.out.println("Order of Entries in TreeMap - Sorted in reverse order");
        System.out.println(sortedCache);
       
        //Using LinkedHashMap to create copy of a Map in Java
        Map<Integer, String> copy = new LinkedHashMap<>(sortedCache);
        System.out.println("Order of Entries in a copy Map created by LinkedHashMap");
        System.out.println(copy);
       
    }
}


