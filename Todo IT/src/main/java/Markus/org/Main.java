package Markus.org;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person kalle = new Person("Kalle", "Svensson", "Kalle.svensson@gmail.com");
        Todoitem running = new Todoitem("Running","run 20 miles", LocalDate.of(2025,5,17),true,kalle);
        TodoitemTask task = new TodoitemTask(true,running,kalle);
        System.out.println(task.getSummary());




    }

}