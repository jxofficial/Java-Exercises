package com.example.JXKENG;

import java.util.*;

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
        Collections.sort(people, (p1, p2) -> {
            return p1.age - p2.age;
        });
        printConditionally(people, new Condition() {
            @Override
            public <T extends Person> boolean testCondition(T argument) {
                return true;
            }
        });
        System.out.println("=================");

        // sort by alphabetical order first name
        Collections.sort(people, (p1, p2) -> p1.firstName.compareTo(p2.firstName));

        printConditionally(people, new Condition() {
            @Override
            public <T extends Person> boolean testCondition(T argument) {
                return true;
            }
        });
        System.out.println("=================");

        // Print only People aged below 25
        printConditionally(people, new Condition() {
            @Override
            public <T extends Person> boolean testCondition(T anyPerson) {
                return anyPerson.age < 25;
            }
        });
        System.out.println("=================");

    }


    public static <E extends Person> void printConditionally(List<E> anyListWithPeople, Condition conditionObj) {
        for (int i = 0; i < anyListWithPeople.size(); i++) {
            // this is sort of an object!
            if (conditionObj.testCondition(anyListWithPeople.get(i))) {
                System.out.println(anyListWithPeople.get(i));
            }
        }
    }
}
