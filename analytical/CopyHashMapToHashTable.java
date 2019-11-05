package com.san.analytical;

import java.util.*;

public class CopyHashMapToHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
        
        int digit;
        digit = Integer.parseInt(in.nextLine().trim());
        
        HashMap<String, String> hm = new HashMap<String, String>();
        for(int i=0; i < digit; i++){
        	String key = in.next();
        	String val = in.next();
        	hm.put(key, val);
        }
        
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("Key1", "This");
        ht.put("Key2", "is");
        ht.put("Key3", "Hashtable");
        
      //  ht.putAll(hm); // another way of copying hashMap to hashtable
        
        Iterator it = hm.keySet().iterator(); 
        String ky = "";
        while (it.hasNext()){
        	ky = (String)it.next();
            ht.put(ky, hm.get(ky));   
        }
        
        System.out.println("Before sorting-->"+ ht.toString());
       
        //By default below comparator sorting is not required for ascending order sorting
        
        //Map<String, String> treeMap = new TreeMap<String, String>(ht);
        
        Map<String, String> treeMap = new TreeMap<>(
        		(Comparator<String>)  (o1, o2) -> o2.compareTo(o1)
		        );
		
        treeMap.putAll(ht); 
  
    /*    for (Map.Entry<String, String> entry : treeMap_sorted.entrySet()) {
            System.out.println("Key : " + entry.getKey()
				+ " Value : " + entry.getValue());
        }    
     */
        
        System.out.println("After sorting-->"+treeMap.toString());
        
        Iterator itr = treeMap.entrySet().iterator();
        while(itr.hasNext()){
        	Map.Entry me = (Map.Entry)itr.next();
        	System.out.print("["+me.getKey() + ": "+me.getValue()+"] ");
        }
	}

}
