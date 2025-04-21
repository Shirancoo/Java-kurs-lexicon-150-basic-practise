package Markus.org;

public class TodoitemTask {

    private final int id;
    private boolean assigned;
    private Todoitem todoitem;
    private Person assignee;

    public boolean isAssigned() {

        return assignee != null;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Todoitem getTodoitem() {
        return todoitem;
    }

    public void setTodoitem(Todoitem todoitem) {
        this.todoitem = todoitem;
    }

    public Person getAssignee() {
        if (assigned) return assignee;
        else System.out.println("You are not assigned");
        return null;
    }

    public void setAssignee(Person assignee) {

        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public TodoitemTask(boolean assigned, Todoitem todoitem, Person assignee) {
        this.id = IdGenerator.generateId();
        this.assigned = assigned;
        this.todoitem = todoitem;
        this.assignee = assignee;
    }

    public String getSummary() {
        return "Task ID: (" + id + ") | Is assigned: " + isAssigned() + " | Assignee: " +
                getAssignee().getFirstName() + " " + getAssignee().getLastName() +
                "\nTodoItem: " + getTodoitem().getSummary();

    }
}
