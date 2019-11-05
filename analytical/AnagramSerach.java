package com.san.analytical;

import java.util.*;


public class AnagramSerach {
	
	public static HashMap<String, List> hm = new HashMap<String, List>();
	
	public static ArrayList findAnagrams(HashMap<String, List> hm, String strSearch){
		
		String key = sortString(strSearch);
		List<String> al = hm.get(key);
		
		ArrayList<String> al1 = new ArrayList<String>(); 
		
		
		if(al != null){
			al1.addAll(al);			
		}
		
		if(al == null){
			al = new ArrayList<String>(); 
			al.add(strSearch);
			hm.put(key, al);
		}
		else if(!al.contains(strSearch)){
			al.add(strSearch);
			hm.put(key, al);
		}
			
		return (ArrayList)al1;
	}
	
	public static String sortString(String str){
		
		String val = str;
		char[] chars = val.toCharArray();
        Arrays.sort(chars);
        
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// initialize anagrams with some values
		ArrayList<String> al = new ArrayList<String>(Arrays.asList("anjays", "jaysan"));
		String key = AnagramSerach.sortString("anjays");
		hm.put(key, al);
		
		// Initial anagram status
		System.out.println("Initial Anagrams-->"+hm.toString());
		
		// Call the anagram functions
		ArrayList<String> strSrchList;
		strSrchList = AnagramSerach.findAnagrams(hm, "neetu");
		
		//Print the anagram search results
		System.out.println("Anagrams for Neetu-->"+strSrchList.toString());
		
		//New anagram search
		strSrchList = AnagramSerach.findAnagrams(hm, "sanjay");
		
		//Print the anagram search results
		System.out.println("Anagrams for sanjay-->"+strSrchList.toString());
		
		// Final anagram status
		System.out.println("Final Anagrams-->"+hm.toString());
		
	
	}

}
