package com.san.newfeatures.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class TestStream_GroupingBy_mapping {

    public static void main(String[] args) {
    	
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
                );

		//group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
			items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println("GroupBy Price ->\n"+groupByPriceMap);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println("GroupBy Price and Map List<Item> to Set<String> ->\n"+result);
        
        // group by name, then count of each name as map
        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println("GroupBy name and its count ->\n"+counting);

        // group by name, then sum of each type as map
        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println("GroupBy name and sum of Qty ->\n"+sum);        

    }
}
