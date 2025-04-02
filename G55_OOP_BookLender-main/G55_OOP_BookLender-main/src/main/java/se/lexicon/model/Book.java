package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    static int sequencer = 1;
    private final int id;
    private final String title;
    private final String author;
    private boolean available;

    public Book(String title, String author, boolean available) {
        this.id = sequencer++;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println(title + " has been returned.");
    }

    public String getBookInfo() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Available: " + (available ? "Yes" : "No");
    }
}

