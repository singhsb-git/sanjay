package com.san.collection;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TestTreeMap_Dog {
	public static void main(String[] args) {
		TreeMapKey_Dog d1 = new TreeMapKey_Dog("red", 30);
		TreeMapKey_Dog d2 = new TreeMapKey_Dog("black", 20);
		TreeMapKey_Dog d3 = new TreeMapKey_Dog("white", 10);
		TreeMapKey_Dog d4 = new TreeMapKey_Dog("white", 10);
		TreeMap<TreeMapKey_Dog, Integer> treeMap = new TreeMap<TreeMapKey_Dog, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);
		
		for (Entry<TreeMapKey_Dog, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
