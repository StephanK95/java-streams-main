package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream().map(Person::getFirstName).sorted().collect(Collectors.toList());
        sorted.forEach(System.out::println);

    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        Comparator<String> comparator = Comparator.reverseOrder();
        List<String> sorted = people.stream().map(Person::getFirstName).sorted(comparator).collect(Collectors.toList());
        sorted.forEach(System.out::println);

    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> reversed = Comparator.comparing(Person::getFirstName).reversed().thenComparing(Person::getAge);

        List<Person> sort = people.stream()
                .sorted(reversed).collect(Collectors.toList());
        sort.forEach(System.out::println);


    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();

        Comparator<Car> comparing = Comparator.comparing(Car::getPrice);

        List<Car> collect = cars.stream().filter(car -> car.getColor().equalsIgnoreCase("blue")).sorted(comparing).limit(10).collect(Collectors.toList());

        collect.forEach(System.out::println);

    }

}
