package com.san.collection;

import java.util.*;

public class HashMapTest_BadImplementation {

	public static void main(String[] args) {
        Map <Key_BadImplementation, String> cityMap = new HashMap<Key_BadImplementation, String>();
        cityMap.put(new Key_BadImplementation(1, "NY"),"New York City" );
        cityMap.put(new Key_BadImplementation(2, "ND"), "New Delhi");
        cityMap.put(new Key_BadImplementation(3, "NW"), "Newark");
        cityMap.put(new Key_BadImplementation(4, "NP"), "Newport");

        System.out.println("size before iteration " + cityMap.size());
        Iterator <Key_BadImplementation> itr = cityMap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(cityMap.get(itr.next()));     
        }
        System.out.println("size after iteration " + cityMap.size());    
    }


}
