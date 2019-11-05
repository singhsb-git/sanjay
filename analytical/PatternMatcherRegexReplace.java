package com.san.analytical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherRegexReplace {
    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        System.out.println("*** Test for start/end/group/replaceAll");
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        // now create a new pattern and matcher to replace whitespace with tabs
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("\t"));
        
        // usage of regular expression and appendReplacement and appendTail
        System.out.println("\n*** Test for appendReplacement/appendTail");
        String REGEX = "a*b";
        String INPUT = "aabbfooaabfooabfoob.";
        String REPLACE = "-";
        
        Pattern p = Pattern.compile(REGEX);
        
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()) {
           m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println("Input -> "+INPUT);
        System.out.println("Output -> "+sb.toString());
        
        System.out.println("\n*** Test for appendReplacement/appendTail");
        REGEX = "\\bcat\\b";
        INPUT = "cat cat cat cattie cat";
        p = Pattern.compile(REGEX);
        m = p.matcher(INPUT);   // get a matcher object
        int count = 0;

        while(m.find()) {
           count++;
           System.out.println("Match number "+count);
        }
        
        // Pattern check using String class
        System.out.println("\n*** Test for Pattern check using String class");
        testSimpleTrue();

    }
    
    public static void testSimpleTrue() {
        String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String s= "1233323322";
        System.out.println(s.matches(pattern));
        s = "1233323";
        System.out.println(s.matches(pattern));
        s = "123 3323";
        System.out.println(s.matches(pattern));
    }
}