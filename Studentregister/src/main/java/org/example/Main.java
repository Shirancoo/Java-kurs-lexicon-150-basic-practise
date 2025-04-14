package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Programs programs = new Programs();
        Student student1 = new Student(18, "Kalle", StudyProgram.ECONOMICS);


        student1.displayinfo();
        boolean isRunning = true;
        while (isRunning) {
            int choice;
            System.out.println("HELLO AND WELCOME ");
            System.out.println("Make a Choise");
            System.out.println("1: for info about students\n2: For info about what Program that exit\n3: For exit ");
            choice = input.nextInt();
            switch (choice) {
                case 1 ->
                        programs.displayinfo();
                case 2 ->
                    programs.displayinfo();
                case 3 ->
                    isRunning = false;
            }

        }
    }
}