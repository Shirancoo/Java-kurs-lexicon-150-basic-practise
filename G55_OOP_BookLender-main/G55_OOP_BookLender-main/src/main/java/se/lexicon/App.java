package se.lexicon;

import se.lexicon.model.Book;
import se.lexicon.model.Person;

import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    public static boolean isRunning = true;

    public static void main(String[] args) {
        Person markus = new Person("Markus", "Agersten", "klinta", "markus");
        Person kalle = new Person("Kalle", "Hanssen", "798852", "kalle");

        Book bjornFolket = new Book("Björnfolket", "J.J.R", true);
        Book lotr = new Book("Lord of the Rings", "J.R.R. Tolkien", false);

        System.out.println(bjornFolket.getBookInfo());
        System.out.println(lotr.getBookInfo());
        System.out.println(markus.getPersonInformation());
        System.out.println(kalle.getPersonInformation());

        isLoggedIn(markus, kalle, bjornFolket, lotr);
    }

    private static void isLoggedIn(Person markus, Person kalle, Book bjornFolket, Book lotr) {
        System.out.print("Enter username: ");
        String inputName = input.next();

        Person loggedInUser = inputName.equalsIgnoreCase("markus") ? markus :
                inputName.equalsIgnoreCase("kalle") ? kalle : null;

        if (loggedInUser != null) {
            menu(loggedInUser, bjornFolket, lotr);
        } else {
            System.out.println("Invalid username. Try again.");
            isLoggedIn(markus, kalle, bjornFolket, lotr);
        }
    }

    private static void menu(Person user, Book bjornFolket, Book lotr) {
        while (isRunning) {
            System.out.println("\n1. View available books");
            System.out.println("2. View personal information");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(bjornFolket.getBookInfo());
                    System.out.println(lotr.getBookInfo());
                    break;
                case 2:
                    System.out.println(user.getPersonInformation());
                    break;
                case 3:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = input.next();
                    if (borrowTitle.equalsIgnoreCase("Björnfolket")) user.borrowBook(bjornFolket);
                    else if (borrowTitle.equalsIgnoreCase("Lord of the Rings")) user.borrowBook(lotr);
                    else System.out.println("Book not found.");
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = input.next();
                    if (returnTitle.equalsIgnoreCase("Björnfolket")) user.returnBook(bjornFolket);
                    else if (returnTitle.equalsIgnoreCase("Lord of the Rings")) user.returnBook(lotr);
                    else System.out.println("Book not found.");
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
