import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Write a Java program to compare two numbers.
            Input Data:
            Input first integer: 25
            Input second integer: 39
            Expected Output

            25 != 39
            25 < 39
            25 <= 39

         */
        Scanner input = new Scanner(System.in);
        int number1;
        int number2;


        System.out.println("Input first integer: ");
        number1 = input.nextInt();
        System.out.println("Input second integer: ");
        number2 = input.nextInt();

        if (number1 == number2) {
            System.out.println(number1 + " are equal to  " + number2);

        } else if (number1 < number2) {
            System.out.println(number1 + " are less than  " + number2);

        } else {
            System.out.println(number1 + " are greater than  " + number2);

        }

        input.close();
    }


}