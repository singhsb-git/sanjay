package com.san.misc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateHandling {
	
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
		
		Date strTime = new Date();
		List<Integer> lst = getPrime_Method2(101);	
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

	}

}
