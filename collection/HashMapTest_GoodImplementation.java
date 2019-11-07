package com.san.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest_GoodImplementation {

	public static void main(String[] args) {
        Map <Key_GoodImplementation, String> cityMap = new HashMap<Key_GoodImplementation, String>();
        cityMap.put(new Key_GoodImplementation(1, "NY"),"New York City" );
        cityMap.put(new Key_GoodImplementation(2, "ND"), "New Delhi");
        cityMap.put(new Key_GoodImplementation(3, "NW"), "Newark");
        cityMap.put(new Key_GoodImplementation(4, "NP"), "Newport");
        cityMap.put(new Key_GoodImplementation(4, "NJ"), "Jersey City");

        System.out.println("size before iteration " + cityMap.size());
        Iterator <Key_GoodImplementation> itr = cityMap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(cityMap.get(itr.next()));   
        }
        System.out.println("size after iteration " + cityMap.size());    
    }


}

