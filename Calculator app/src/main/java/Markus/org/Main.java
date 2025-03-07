package Markus.org;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

   

        while (true) {

            System.out.println("Choose an operation: +, -, *, / or type 'exit' to quit the program. \nIf you want to separate decimal numbers. Use a comma (,)");
            String whatMath = input.next();

            if (whatMath.equals("exit")) {
                System.out.println("program closes.");
                break;

            } else if (whatMath.equals("+")) {

                System.out.println("Write a Number You want to add ");
                double a = input.nextDouble();
                System.out.println("Write a Number second You want to add ");
                double b = input.nextDouble();
                double sum = a + b;
                System.out.println("Total sum are: " + sum);

            } else if (whatMath.equals("-")) {

                System.out.println("Write a Number You want to add ");
                double a = input.nextDouble();
                System.out.println("Write a Number second You want to add ");
                double b = input.nextDouble();
                double sum = a - b;
                System.out.println("Total sum are: " + sum);

            } else if (whatMath.equals("*")) {

                System.out.println("Write a Number You want to add ");
                double a = input.nextDouble();
                System.out.println("Write a Number second You want to add ");
                double b = input.nextDouble();
                double sum = a * b;
                System.out.println("Total sum are: " + sum);

            } else if (whatMath.equals("/")) {


                System.out.println("Write a Number You want to add ");
                double a = input.nextDouble();
                System.out.println("Write a Number second You want to add ");
                double b = input.nextDouble();
                if (b == 0) {
                    System.out.println("Cannot divide by zero..");
                }
                if (a == 0) {
                    System.out.println("Cannot divide by zero. Please Chose one of the operations below");
                } else {
                    double sum = a / b;
                    System.out.println("Total sum are: " + sum);

                }

            } else {
                System.out.println("please assign an operation: +, -, *, / or type 'exit' to quit the program.");
            }
        }


    }
}

