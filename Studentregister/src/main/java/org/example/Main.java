package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean isRunning = true;
        while (isRunning) {
            int choice;
            System.out.println("-------------------");
            System.out.println("HELLO AND WELCOME");
            System.out.println("Make a choice:");
            System.out.println("1: Add student\n2: Info about students\n3: Remove student\n4: Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter name:");
                    String studentName = input.next();
                    System.out.println("Enter age:");
                    int studentAge = input.nextInt();
                    System.out.println("Enter program:");
                    String studentProgram = input.next();
                    students.add(new Student(studentAge, studentName, studentProgram));
                }
                case 2 -> {
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
                case 3 -> {
                    System.out.println("Which student would you like to remove?");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    String studentName = input.next();

                    boolean removed = students.removeIf(s -> s.getName().equalsIgnoreCase(studentName));

                    if (removed) {
                        System.out.println("Removed student: " + studentName);
                    } else {
                        System.out.println("No student found with that name.");
                    }
                }
                case 4 -> isRunning = false;
            }
        }
    }
}
