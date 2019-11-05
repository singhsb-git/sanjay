package com.san.newfeatures.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream_Filter_Map_Collect_FindAny_OrElse {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName).map(String::toUpperCase)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        
        // Multiple conditions -------------------------------
        
        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream().parallel() // for running in parallel mode
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

    }

}
