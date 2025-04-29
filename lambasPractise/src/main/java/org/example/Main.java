package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anders", 2));
        persons.add(new Person("Johan", 2));
        persons.add(new Person("Kalle", 2));
        persons.add(new Person("Greta", 2));
        persons.add(new Person("Anne", 8));


        persons.stream().filter(p -> p.getAge() < 18).forEach(person ->
                System.out.print("\nAge: " + person.getAge() + " Name: " + person.getName()));


        persons.stream().sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).forEach(p ->
                System.out.print("\nName: " + p.getName() + " "));


        persons.stream().filter(person -> person.getName().equals("Anne")).findFirst()
                .ifPresent(person -> System.out.print("\nPerson found: " + person.getName()));


        long count = persons.stream().filter(person -> person.getAge() > 30).count();
        System.out.println("\nNumber of people older than 30: " + count + " persons");

       double avragePersonAge = persons.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(avragePersonAge);
    }
}
