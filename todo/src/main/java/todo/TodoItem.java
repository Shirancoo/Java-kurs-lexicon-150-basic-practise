package todo;

import java.time.LocalDateTime;

public class TodoItem {
    private int id;
    private String description;
    private LocalDateTime dueDate;
    private boolean completed;
    private Person assignee;

    public TodoItem() {
    }

    public TodoItem(int id, String description, LocalDateTime dueDate, boolean completed, Person assignee) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}
