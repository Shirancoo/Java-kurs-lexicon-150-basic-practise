import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

//Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.
//Test Data:
//Input first number: 125
//Input second number: 24
//Expected Output :
//125 + 24 = 149
//125 - 24 = 101
//125 x 24 = 3000
//125 / 24 = 5
//125 mod 24 = 5//



        Scanner input = new Scanner(System.in);

        System.out.println("Input first number: ");
        int aa = input.nextInt();
        System.out.println("Input second number: ");
        int bb = input.nextInt();


        System.out.println("Test Data:");
        System.out.println( aa +  " + " +   bb  + " = " +(aa+bb) );
        System.out.println( aa +  " - " +   bb  + " = " +(aa-bb) );
        System.out.println( aa +  " * " +   bb  + " = " +(aa*bb) );
        System.out.println( aa +  " / " +   bb  + " = " +(aa/bb) );
        System.out.println( aa +  " % " +   bb  + " = " +(aa%bb) );
        input.close();

    }
}