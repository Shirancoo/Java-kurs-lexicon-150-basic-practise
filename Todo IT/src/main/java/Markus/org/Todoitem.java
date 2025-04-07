package Markus.org;

import java.time.LocalDate;

public class Todoitem {

    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private boolean overdue;


    public String getTitle() {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return "Title: " + title;
    }

    public void setTitle(String title) {

        this.title = title;


    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        if (LocalDate.now().isBefore(deadLine)) {
            System.out.println("There is still time before the deadline.");
        } else {
            System.out.println("Deadline has passed or is today.");
        }
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        if (!done) {
            System.out.println("You have not completed your task");
            return false;
        } else
            return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    public Todoitem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this.id = IdGenerator.generateId();
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }
    public String getSummary() {
        return " ID: " + id + " | Title: " + getTitle() + " | Deadline: " + getDeadLine() + " | Creator: " + getCreator();
    }
}
