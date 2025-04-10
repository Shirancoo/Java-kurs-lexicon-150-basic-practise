package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<String> Days = new ArrayList<String>(); */
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Thursday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        System.out.println(days);


        // iterate through it and print//
        for (String day : days) {
            System.out.println(day);
        }
        /*  Create a new list and populate it with the days of the week excluding THURSDAY. Lastly,
            insert the weekday THURSDAY into the right position in the list. */

        ArrayList<String> days2 = new ArrayList<String>();
        days2.add("Monday");
        days2.add("Tuesday");
        days2.add("Wednesday");
        days2.add("Friday");
        days2.add("Saturday");
        days2.add("Sunday");
        days2.add(3, "THURSDAY");

        System.out.println(days2);
        //Create a new list and populate it with the days of the week. Then create a new list out of the
        //first three elements of the first list using a subList.
        String days3 = String.valueOf(days2.subList(0, 3));
        System.out.println(days3);


        //Create a new hashset and populate it with the days of the week. Lastly, print the set out and
        //pay attention to the order of the elements


        HashSet<String> daysHash = new HashSet<>();
        daysHash.add("kalle");
        daysHash.add("johan");
        daysHash.add("markus");
        daysHash.add("Adam");
        ArrayList<String> nameL = new ArrayList<>(daysHash);
        Collections.sort(nameL);
        System.out.println(nameL);


    }
}