package Markus.org;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        //Exercise 1:
        //Create a LocalDate of the current day and print it out

        System.out.println(LocalDate.now());

        //Exercise 2:
        //Create a LocalDate of the current day and print it out in the following pattern using
        //DateTimeFormatter: Torsdag 29 mars.
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("eeee dd MMM ")));

        //Exercise 3:
        //Create a LocalDate of last Monday. Then print out the entire week in a loop using standard ISO
        //format.

        System.out.println(LocalDate.now().minusDays(1));
        for (int i = 0; i < 7; i++) {
            LocalDate day = LocalDate.now().minusDays(i);
            System.out.println(day);
        }

        //Exercise 4:
        //Create a LocalDate object from a String by using the .parse() method.
        String timeS = "2024-03-12";
        LocalDate time = LocalDate.parse(timeS);
        System.out.println("this is a string -> " + timeS);

        //Exercise5
        //The date time api provides enums for time units such as day and month.
        //Create a LocalDate of your birthday and extract the day of week for that date.
        //Ex. 1945-05-08 -> TUESDAY

        System.out.println(LocalDate.of(1990, 9, 10).format(DateTimeFormatter.ofPattern("eeee")));

        //Exercise6
        //Create a LocalDate of current date plus 10 years and minus 10 months. From that date extract the
        //month and print it out.
        System.out.println(LocalDate.now().plusYears(10).minusMonths(10));

        //Exercise7
        //Using the LocalDate from exercise 6 and your birthdate, create a Period between your birthdate and
        //the date from exercise 5. Print out the elapsed years, months and days.
        LocalDate startDate = LocalDate.of(1945, 5, 8);
        LocalDate endDate = LocalDate.of(1990, 9, 10);

        Period period = (startDate.until(endDate));
        System.out.println("imellan " + startDate + " och " + endDate + " är det");
        System.out.println("år " + period.getYears());
        System.out.println("dagar " + period.getDays());
        System.out.println("månader " + period.getMonths());
        //Exercise 8
        //Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current date and add
        //the period you created to the current date.


        Period periodOf = (Period.of(4, 7, 29));
        time = LocalDate.now().plus(periodOf);

        System.out.println(time);


        //Exercise 9
        //Create a LocalTime object of the current time.

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //Exercise 10
        //Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.
        System.out.println(LocalTime.ofSecondOfDay(1));

        //Exercise 11
        //Create a LocalTime object from a String using the .parse() method.
        String local = "19:30";
        LocalTime timess = LocalTime.parse(local);
        System.out.println(timess);
        //Exercise 12
        //Using DateTimeFormatter format LocalTime from current time and print it out as following pattern:
        //10:32:53



    }
}