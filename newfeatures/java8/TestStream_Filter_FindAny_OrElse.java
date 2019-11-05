package com.san.newfeatures.java8;

import java.util.Arrays;
import java.util.List;

public class TestStream_Filter_FindAny_OrElse {

    public static void main(String[] args) {
    	
    	List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
    	
    	System.out.println("Original List: "+persons);

        Person result = getStudentByName(persons, "jack");
        System.out.println("Result found for - Before Java 8 - find jack: "+result);
        

        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println("Result found for - Java 8 - find jack (Stream-filter-findAny-orElse): "+result1);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println("Result found for - Java 8 - find ahmook (Stream-filter-findAny-orElse): "+result2);

    }
    

    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }    

}