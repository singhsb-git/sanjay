package com.san.newfeatures.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String args[]){

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // sum of list of numbers
        Integer sum = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum ------->"+ sum);

        // sum of list of square of numbers
        Integer sumSq = integers.stream()
                .map(val -> getSquare(val))
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of squares using map & summingInt ------->"+ sumSq);

        // sum of list of numbers reduce
        Integer sum1 = integers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum using reduce ------->"+ sum1);

        // sum of list of numbers using reduce (Integer::sum)
        Integer sum2 = integers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum using reduce (Integer::sum)------->"+ sum2);
    }

    public static int getSquare(int val){
        return (val * val);
    }
}
