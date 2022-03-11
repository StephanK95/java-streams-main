package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> collect = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(
                        Car::getMake
                ));

        collect.forEach((s, cars) -> {
            System.out.println("Make " + s);
            cars.forEach(System.out::println);
            System.out.println("________________________");
        });



    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

    }

}