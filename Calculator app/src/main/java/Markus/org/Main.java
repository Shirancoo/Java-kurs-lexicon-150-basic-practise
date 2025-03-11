package Markus.org;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean validOperation = true;
        while (validOperation) {
            double num1;
            double num2;
            char operator;
            double result = 0;


            System.out.println("Enter the first number");
            num1 = input.nextDouble();
            System.out.println("Enter an operator (+, -, *, / ):");
            operator = input.next().charAt(0);
            System.out.println("Enter the second number");
            num2 = input.nextDouble();

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("you cant / with 0");
                        validOperation = false;
                    } else {
                        result = num1 / num2;

                    }

                }
                default -> {
                    System.out.println("Invalid operation");
                    validOperation = false;
                }
            }
            if (validOperation) {
                System.out.println(result);
            }

        }
        input.close();
    }

}


