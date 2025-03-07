
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/*
        System.out.println("Hello");
        System.out.println("Ali!");

        int year;

        System.out.println("write a year: ");
        year = input.nextInt();
        boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);

        if (isLeapYear)
            System.out.println("its a leap year ");
        else {
            System.out.println("its not a leap year ");
        }



        double a, b;

        System.out.println("write a number: ");
        a = input.nextDouble();
        System.out.println("write number two: ");
        b = input.nextDouble();

        sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
        sum = a * b;
        System.out.println(a + " * " + b + " = " + sum);
        sum = a / b;
        System.out.println(a + " / " + b + " = " + sum);
        sum = a - b;
        System.out.println(a + " - " + b + " = " + sum);
        sum = a % b;
        System.out.println(a + " % " + b + " = " + sum);





        System.out.println("Print first number that you want the Median of:");
        double number1 = input.nextInt();
        System.out.println("Print second number that you want the Median of: ");
        double number2 = input.nextInt();
        System.out.println("Print third number that you want the Median of: ");
        double number3 = input.nextInt();

        double median = (number1 + number2 + number3) / 3;

        System.out.println( "(" + number1 + " + "  + number2 + " + "  + number3 + ")"  + "/ 3 "  + " = " + median);


        System.out.println("Write your first and last name");
        String username = input.next();
        System.out.println("Hello " + username);


     System.out.println("Write how many seconds: ");
        double seconds = input.nextDouble();
        double hours = (seconds / 3600) ;
        seconds %= 3600;

        double minutes = seconds / 60;
        seconds %= 60;



        System.out.println( hours + "h " +  "\n" + minutes + "min" + "\n" +seconds +"S");

*/
        Random rand = new Random();

        int number = rand.nextInt(1, 500);
        int guess = -1;
        int guesses = 0;

        System.out.println("guess a number : ");


        while (guess != number) {
            System.out.println("guess a number : ");
            guess = input.nextInt();
            guesses += 1;
            System.out.println("you guessed  " + guesses + " times ");

            if (guess < number) {
                System.out.println("You need to guess higher");
            } else if (guess > number) {
                System.out.println("You need to guess lower");
            } else {
                System.out.println("You made it");
            }


        }
    }
}








