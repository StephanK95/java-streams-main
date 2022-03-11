package com.amigoscode.optionals;

import java.util.Locale;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        /*Optional<String> hello = Optional.ofNullable(null);

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello.map(String::toUpperCase).orElse("world");

        hello.ifPresent();
        System.out.println(orElse);*/

        Person person = new Person("james", null);
        String email = person.getName().map(String::toLowerCase).orElse("Email is not provided");
        System.out.println(email);


    }
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(email);
    }

    public String getEmail() {
        return email;
    }
}
