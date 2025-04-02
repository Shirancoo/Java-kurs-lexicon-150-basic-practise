
package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    static int sequencer = 1;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public Person(String firstName, String lastName, String password, String username) {
        this.id = sequencer++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("You don’t have this book.");
        }
    }

    public String getPersonInformation() {
        return "Person ID: " + id + ", Name: " + firstName + " " + lastName +
                ", Borrowed books: " + borrowedBooks.size();
    }
}