package com.san.misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BusinessDay {
	
	

	public boolean isBusinessDay(Calendar cal){
		// check if weekend
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
		   || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			return false;
		}
		
		// check if New Year's Day
		if (cal.get(Calendar.MONTH) == Calendar.JANUARY
			&& cal.get(Calendar.DAY_OF_MONTH) == 1) {
			return false;
		}
		
		// check if Christmas
		if (cal.get(Calendar.MONTH) == Calendar.DECEMBER
			&& cal.get(Calendar.DAY_OF_MONTH) == 25) {
			return false;
		}
		
		// check if 4th of July
		if (cal.get(Calendar.MONTH) == Calendar.JULY
			&& cal.get(Calendar.DAY_OF_MONTH) == 4) {
			return false;
		}
		
		// check Thanksgiving (4th Thursday of November)
		if (cal.get(Calendar.MONTH) == Calendar.NOVEMBER
			&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 4
			&& cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
			return false;
		}
		
		// check Memorial Day (last Monday of May)
		if (cal.get(Calendar.MONTH) == Calendar.MAY
			&& cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY
			&& cal.get(Calendar.DAY_OF_MONTH) > (31 - 7) ) {
			return false;
		}
		
		// check Labor Day (1st Monday of September)
		if (cal.get(Calendar.MONTH) == Calendar.SEPTEMBER
			&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1
			&& cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return false;
		}
		
		// check President's Day (3rd Monday of February)
		if (cal.get(Calendar.MONTH) == Calendar.FEBRUARY
		&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 3
		&& cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
		return false;
		}
		
		// check Veterans Day (November 11)
		if (cal.get(Calendar.MONTH) == Calendar.NOVEMBER
		&& cal.get(Calendar.DAY_OF_MONTH) == 11) {
		return false;
		}
		
		// check MLK Day (3rd Monday of January)
		if (cal.get(Calendar.MONTH) == Calendar.JANUARY
		&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 3
		&& cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
		return false;
		}
		
		// IF NOTHING ELSE, IT'S A BUSINESS DAY
		return true;
	}
	
	
	public Calendar getNextBusinessDay(Calendar cal){
		cal.add(Calendar.DATE, 1);
		
		while(true)
		{
			if(!isBusinessDay(cal))
				cal.add(Calendar.DATE, 1);
			else
				return cal;
		}
	}
	
	public static void main(String[] args) {
		 
		Date currentDate = new Date();
		//System.out.println(DateFormat.format(currentDate)); 

        // convert date to calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, -4);
        
        BusinessDay bd = new BusinessDay();
        
        if(bd.isBusinessDay(cal))
        	 System.out.println("Current Date ("+cal.getTime().toString()+"): "+ "is a BusinessDay.");
        else
        	System.out.println("Current Date ("+cal.getTime().toString()+"): "+ " is a Holiday.");
           
        cal = bd.getNextBusinessDay(cal);
        
        System.out.println("Next BusinessDay: "+cal.getTime().toString());

		 
	 }
	 

}
