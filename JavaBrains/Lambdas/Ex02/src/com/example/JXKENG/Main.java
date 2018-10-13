package com.example.JXKENG;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Javier", "Lim", 20),
                new Person("Nicole", "Ng", 23),
                new Person("Steven", "Le", 21),
                new Person("Conor", "McGregor", 30),
                new Person("Lewis", "Campbell", 51),
                new Person("Sam", "Puckett", 29)
        );


        // sort by age
        Collections.sort(people, (p1, p2) -> p1.age - p2.age);

        // printing by age
        System.out.println("Printing by age");
        printConditionally(people, p1 -> true, p -> System.out.println(p));
        System.out.println("=================");

        // printing only first names that start with S
        System.out.println("Printing names that start with S");
        printConditionally(people, p1 -> p1.firstName.startsWith("S"), p -> System.out.println(p.firstName));
        System.out.println("=================");

    }

    public static <T extends Person> void printConditionally(List<T> anyListWithPeople, Predicate<T> predicateObj,
                                                             Consumer<T> consumerObj) {
        for (T p : anyListWithPeople) {
            // this is sort of an object!
            if (predicateObj.test(p)) {
                consumerObj.accept(p);
            }
        }
    }
}

