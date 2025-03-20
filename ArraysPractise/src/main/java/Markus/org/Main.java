package Markus.org;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int[] number = {11, 23, 39};
        int[] arra = {1, 5, 6, 2, 74, 5, 6, 7, 5, 98};
        int max = arra[0]; // 74
        int min = arra[0];
        String[] names = {"Sofia", "Johan", "Lasse", "Kalle", "Anders"};

        System.out.println("Assignment 1 output");

        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }

        System.out.println("--------------------------------");
        System.out.println("Assignment 2 output");

        for (int i = 1; i < arra.length; i++) {
            int element = arra[i];

            if (max < element) {
                max = element;
            }
        }


        System.out.println(max);
        System.out.println(min);


        System.out.println("--------------------------------");
        System.out.println("Assignment 3 output");
        Arrays.sort(names);

        for (String value : names) {
            System.out.println(value);
        }
        System.out.println("--------------------------------");
        System.out.println("Assignment 4 output");

        int[] firstArray = {1, 4, 8767, 321, 66, 5};
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);

        System.out.println(Arrays.toString(secondArray));

        System.out.println("--------------------------------");
        System.out.println("Assignment 5 output");

        String[][] countries = {{"France", "Sweden"},
                {"Paris", "Stockholm"}};

        for (int i = 0; i < countries.length; i++) {
            System.out.println(countries[i][0] + " " + countries[i][1]);


        }
        System.out.println("--------------------------------");
        System.out.println("Assignment 6 output");

        double[] averageOfNumbers = {43, 5, 23, 17, 2, 14};

        double sum = 0;
        for (double value : averageOfNumbers) {
            sum += value;

        }
        double avrage = sum / averageOfNumbers.length;
        System.out.println(avrage);

        System.out.println("--------------------------------");
        System.out.println("Assignment 7 output");
        int[] evenNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (int value : evenNumber) {
            if (value % 2 == 1)
                System.out.println(value);
        }

    }


}











