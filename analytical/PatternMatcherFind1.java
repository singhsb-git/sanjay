package com.san.analytical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find out if a String contains a very simple pattern.
 */
public class PatternMatcherFind1
{
  public static void main(String[] args)
  {
    String stringToSearch = "Four scorescore and seven years ago our fathers score...";

    Pattern p = Pattern.compile("score");   // the pattern to search for
    Matcher m = p.matcher(stringToSearch);
    
    
    // now try to find at least one match
    if(m.find()){
      System.out.println("Found a match -> "+m.group());
      while(m.find()){
    	  System.out.println("Found a match -> "+m.group());
      } 
    }
    else
      System.out.println("Did not find a match");
  }
}
