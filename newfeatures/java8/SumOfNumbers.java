package com.san.newfeatures.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String args[]){

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // sum list of numbers
        Integer sum = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum ------->"+ sum);

        // sum list of square of numbers
        Integer sumSq = integers.stream()
                .map(val -> getSquare(val))
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of squares ------->"+ sumSq);


    }

    public static int getSquare(int val){
        return (val * val);
    }
}
