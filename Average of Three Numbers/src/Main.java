import java.util.Scanner;
import java.lang.Math.*;
public class Main {
    public static void main(String[] args) {

        /*
        Write a Java program that takes three numbers as input to calculate and print the average of the numbers.
         */
        Scanner input = new Scanner(System.in);
        // Övning 12 //

        System.out.println("Skriv första median numret: ");
        double median1 = input.nextDouble();

        System.out.println("Andra median numret: " );
        double median2 = input.nextDouble();

        System.out.println("Tredje median numret: " );
        double median3 = input.nextDouble();

        double medianSum = median1 + median2 + median3;
        System.out.println("Din median är: " + medianSum /3 );
        input.close();

    }
}