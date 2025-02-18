import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Test Data:");

        System.out.println("Input first number " );
        int firstProduct = input.nextInt();

        System.out.println("Input second number " );
        int secondProduct = input.nextInt();

        int sumOfProduct = firstProduct * secondProduct;
        System.out.println(firstProduct + " * " + secondProduct  + " = " + sumOfProduct);

        input.close();
        }

    }
