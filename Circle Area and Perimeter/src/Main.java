import java.lang.Math.*;
public class Main {

    public static void main(String[] args)

        /*
        Write a Java program to print the area and perimeter of a circle.
        Test Data:
        Radius = 7.5
        Expected Output
        Perimeter is = 47.12388980384689
        Area is = 176.71458676442586
 */
    {
        // Övning 11 //

        System.out.println (" ");
        double radius = 7.5;
        double pi = Math.PI;
        System.out.println("your area are " + pi* Math.pow(radius,2) );
        System.out.println("your perimeter are " +  2 * pi * radius);
    }
}