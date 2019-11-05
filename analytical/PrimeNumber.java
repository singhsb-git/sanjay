package com.san.analytical;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PrimeNumber {
	
	//Inefficient algorithm that depends on multiplication
	public static List getPrime_Method1(int primeLimit){
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		for(int i=2; i <= primeLimit; i++){
			hm.put(new Integer(i), "N");
		}
		
		for(int i=2; i<=primeLimit; i++){
			for(int j=i; j <= (primeLimit/2); j++){
				int itmp = i*j;
				String tmp = hm.get(Integer.valueOf(itmp));
				if((tmp != null)&&(tmp.equals("N"))){
					hm.put(Integer.valueOf(itmp), "Y");
				}
			}
		}
		
	   Iterator<Integer> it = hm.keySet().iterator();
	   List<Integer> lst = new ArrayList<Integer>();
	   
	   while(it.hasNext()){
		   Integer in = it.next();
		   String intVal = hm.get(in);
		   if(intVal.equals("N")){
			  // System.out.print(in + ", ");
			   lst.add(Integer.valueOf(in));
		   }
	   }
	   
	   return lst;
	}
	
	
	//Efficient algorithm that depends on division
	public static List getPrime_Method2(int primeLimit){
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i=2; i<=primeLimit; i++){
			int tmp = 0;
			for(int j=i-1; j>1; j--){
				if((i%j) == 0){
					tmp = 1;
					break;
				}
			}
			
			if(tmp == 0) lst.add(i);
		}
		
		return lst;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//First Method
		
		Date strTime = new Date();
		List<Integer> lst = getPrime_Method1(101);	
		Date endTime = new Date();
		
		/* Date Formating-1:
		 	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		 	String formattedDateStart = dateFormat.format(strTime);
			System.out.println("Using DateFormat: "+formattedDateEnd);
		*/
		
		/* Date Formating-2:
			SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String formattedDateStart = sDate.format(strTime);
			System.out.println("Using SimpleDateFormat: "+formattedDateStart);
		*/
		
		Calendar calStr = Calendar.getInstance();
		calStr.setTime(strTime);
		long startMilli = calStr.getTimeInMillis();
		System.out.println("Method-1 StartTime: "+startMilli);
		
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(endTime);
		long endMilli = calEnd.getTimeInMillis();
		System.out.println("Method-1 EndTime: "+endMilli);
		
		System.out.println("Method-1 Performance in Milliseconds: "+(endMilli-startMilli));
		System.out.println(lst.toString());
	
		// Second method
		
		strTime = new Date();
		List<Integer> lst1 = getPrime_Method2(101);
		endTime = new Date();
		
		calStr.setTime(strTime);
		startMilli = calStr.getTimeInMillis();
		System.out.println("Method-2 StartTime: "+startMilli);
		

		calEnd.setTime(endTime);
		endMilli = calEnd.getTimeInMillis();
		System.out.println("Method-2 EndTime: "+endMilli);
		
		System.out.println("Method-2 Performance in Milliseconds: "+(endMilli-startMilli));
		System.out.println(lst1.toString());
		

	}

}
